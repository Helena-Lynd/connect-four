package connectfour.gui;

import connectfour.model.ConnectFourBoard;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConnectFourButtons extends Button {
    private ConnectFourBoard.Player fill;

    private Image empty = new Image(getClass().getResourceAsStream(
            "empty.png"));

    private Image p1 = new Image(getClass().getResourceAsStream(
            "p1black.png"));

    private Image p2 = new Image(getClass().getResourceAsStream(
            "p2red.png"));


    /**
     * Create the button with the image based on the token in it.
     *
     * @param
     */
    public ConnectFourButtons(ConnectFourBoard.Player fill) {
        this.fill = fill;
        Image image;
        switch (fill){
            case P1:
                image = p1;
                break;
            case P2:
                image = p2;
                break;
            default:
                image = empty;
        }

        // set the graphic on the button and make the background white
        this.setGraphic(new ImageView(image));
    }
    public void setImage(ConnectFourBoard.Player fill){
        this.fill = fill;
        Image image;
        switch (fill){
            case P1:
                image = p1;
                break;
            case P2:
                image = p2;
                break;
            default:
                image = empty;
        }
        // set the graphic on the button and make the background white
        this.setGraphic(new ImageView(image));
    }
    public ConnectFourBoard.Player getFill(){
        return this.fill;
    }
}
