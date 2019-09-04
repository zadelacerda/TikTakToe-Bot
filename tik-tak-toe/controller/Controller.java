package controller;

import javafx.application.Application;
import java.util.*;
import model.*;
import view.*;   

public class Controller {
    // private static TikTakToe game;
    // private static View view;
    private static Controller controller;

    private Controller() {
        // game = TikTakToe.getTikTakToe(); // lazy initialization/singleton
        // view = new View();
        // view.startGame();
    }

    // lazy initialization
    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /* view related functions */

    public static void startGame(String[] args) {
        Application.launch(View.class, args);
        ArrayList<String> names = new ArrayList<String>();
        names.add(View.getPlayerName());
        names.add(View.getPlayerName());
        // add icons later
        ArrayList<String> icons = new ArrayList<String>();
        // game.startGame(names, icons);
    }

    public static void gameButtonPressed(boolean turn, String buttonIdString) {
        // update model/gamestate
        TikTakToe.convertInput(buttonIdString);
        if(turn){
            TikTakToe.takeTurn1();
        }
        else{
            TikTakToe.takeTurn2();
        }
    }



    public static void exitButtonPressed() {
        // close program
    }

    /* model related functions */

    // updates view to display winning player
    public static void gameOver(Player player) {
        String winner = player.getName();
        View.showWinner(winner);
    }

    // updates scoreboard with current game count
    public static void updateScoreBoard(int[] score) {

    }

    public static void updateCurrPlayer(Player player) {

    }

}