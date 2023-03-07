package connectfour.gui;

import connectfour.model.ConnectFourBoard;
import connectfour.model.Observer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.Node;
import java.util.Arrays;
import java.util.EnumMap;

import static connectfour.model.ConnectFourBoard.COLS;
import static connectfour.model.ConnectFourBoard.ROWS;

/**
 * A JavaFX GUI for the networked Connect Four game.
 *
 * @author RIT CS
 * @author Helena Lynd
 */
public class ConnectFourGUI extends Application implements Observer<ConnectFourBoard> {
    private ConnectFourBoard model;
    private Label moves;
    private Label player;
    private Label status;
    private ConnectFourButtons[][] board = new ConnectFourButtons[COLS][ROWS];

    @Override
    public void init() {
        this.model = new ConnectFourBoard();
        model.addObserver(this);
    }

    /**
     * Construct the layout for the game.
     *
     * @param stage container (window) in which to render the GUI
     * @throws Exception if there is a problem
     */
    public void start( Stage stage ) throws Exception {

        BorderPane screen = new BorderPane();

        //Organize a border pane for labels and insert into screen pane
        this.moves = new Label();
        moves.setText(model.getMovesMade() + " moves made");
        this.player = new Label();
        player.setText("Current Player: " + model.getCurrentPlayer());
        this.status = new Label();
        status.setText("Status: " + model.getGameStatus());

        BorderPane labels = new BorderPane();
        labels.setLeft(moves);
        labels.setCenter(player);
        labels.setRight(status);

        screen.setBottom(labels);

        //Organize a grid pane for the board and insert into screen pane
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                ConnectFourButtons square = new ConnectFourButtons(ConnectFourBoard.Player.NONE);
                int finalI = i;
                square.setOnAction(event -> {
                    model.makeMove(finalI);
                });
                this.board[i][j] = square;
                gridPane.add(square,i,j);
            }
        }

        screen.setCenter(gridPane);

        Scene scene = new Scene(screen);
        stage.setScene(scene);
        stage.setTitle("ConnectFourGUI");
        stage.show();
    }

    /**
     * Called by the model, model.ConnectFourBoard, whenever there is a state change
     * that needs to be updated by the GUI.
     *
     * @param connectFourBoard the board
     */
    @Override
    public void update(ConnectFourBoard connectFourBoard) {
        moves.setText(model.getMovesMade() + " moves made");
        player.setText("Current Player: " + model.getCurrentPlayer());
        status.setText("Status: " + model.getGameStatus());
        if (model.hasWonGame()) {
            int row = model.lastRow;
            int col = model.lastCol;
            ConnectFourButtons square = this.board[col][row];
            if (model.getCurrentPlayer() == ConnectFourBoard.Player.P1){
                square.setImage(ConnectFourBoard.Player.P2);
            } else {
                square.setImage(ConnectFourBoard.Player.P1);
            }
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    ConnectFourButtons button = this.board[i][j];
                    button.setDisable(true);
                }
            }
        } else {
            int row = model.lastRow;
            int col = model.lastCol;
            ConnectFourButtons square = this.board[col][row];
            if (square.getFill() ==  ConnectFourBoard.Player.NONE){
                square.setImage(model.getCurrentPlayer());
            }
        }
    }

    /**
     * The main method expects the host and port.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}