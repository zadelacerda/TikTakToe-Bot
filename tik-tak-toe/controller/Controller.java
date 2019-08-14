package controller;

import java.util.*;
import model.*;
import view.*;

public class Controller {
    private static TikTakToe game;
    private static View view;
    private static Controller controller = new Controller();

    private Controller() {
        game = TikTakToe.newGame(); // lazy initialization/singleton
        view = new View();
        // view.startGame();
    }

    public static Controller getController() {
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

    public static void gameButtonPressed() {
        // update model/gamestate
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