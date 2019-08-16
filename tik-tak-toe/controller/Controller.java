package controller;

import java.util.*;
import model.*;
import view.*;

public class Controller {
    private static TikTakToe game;
    private static View view;
    private static Controller controller;

    private Controller() {
        game = TikTakToe.newGame(); // lazy initialization/singleton
        view = new View();
        // view.startGame();
    }

    // lazy initialization
    public static Controller getController() {
        if (controller = null) {
            controller = new Controller();
        }
        return controller;
    }

    /* view related functions */

    public void startGame() {
        ArrayList<String> names = new ArrayList<String>();
        names.add(frame.getPlayerName());
        names.add(frame.getPlayerName());
        // add icons later
        ArrayList<String> icons = new ArrayList<String>();
        // game.startGame(names, icons);
    }

    public static void gameButtonPressed(String whichTurn, String buttonIdString) {
        // update model/gamestate
        game.convertInput(buttonIdString);
        if(whichTurn == "X"){
            game.takeTurn1();
        }
        else{
            game.takeTurn2();
        }
    }

    public static void exitButtonPressed() {
        // close program
    }

    /* model related functions */

    // updates view to display winning player
    public static void gameOver(Player player) {

    }

    // updates scoreboard with current game count
    public static void updateScoreBoard(int[] score) {

    }

    public static void updateCurrPlayer(Player player) {

    }

}