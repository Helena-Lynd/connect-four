# connect-four-game<br>
A Java program that creates a GUI for users to play the game Connect Four.

![ProgramResults](https://github.com/Helena-Lynd/connect-four-game/blob/main/connect-four-playing.png)

## Description<br>
The game of connect four can be played locally with another person. The first person to click a column will be player one, the second person will be player two. The program displays which player's turn it is, how many turns have been taken in total, and the status of the game (NOT_OVER if the game is in progress, PLAYERX_WON when a player wins).

## Getting Started<br>
### Dependencies
- Java 18+
- IntelliJ IDE
### Installing
- Download the source files provided to your directory of choice
```
git clone git@github.com:Helena-Lynd/connect-four-game.git
```
### Executing
- Open the project in IntelliJ
- Play the given run configuration or the file "ConnectFourGUI.java"
- The game will end once a player wins, as shown below.<br>
![ProgramResults](https://github.com/Helena-Lynd/connect-four-game/blob/main/connect-four-finished.png)
## Modifying
- You can make custom pieces by replacing the files "src/connectfour/gui/p1black.png" and "src/connectfour/gui/p2red.png" with your preferred images. Do not change the names of these files, as the program uses the path of the images to load them.
## Common Errors
"Imports could not be resolved"
- Ensure that your JDK is configured for the project
- Right-click on the "src" folder and <i>Mark as Sources Root</i>
## Authors<br>
Helena Lynd
