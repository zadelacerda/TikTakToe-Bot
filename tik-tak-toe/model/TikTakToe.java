package model;

import java.util.*;


import controller.Controller;   

/**
 * Zephren de la Cerda Tik-Tak-Toe 8/1/2019 Benjamin Larkin
 **/
public class TikTakToe {

    private static TikTakToe game = new TikTakToe();
    private static String[][] gameboard;
    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;
    private static int total_turns;
    private static final String X = "X";
    private static final String O = "O";
    private static int inputX;
    private static int inputY;


    private void startGame(ArrayList<String> names, ArrayList<String> icons) {
        Controller controller = Controller.getController();
        initPlayers(names, icons);
        initBoard();
        total_turns = 0;
    }

    private void initPlayers(ArrayList<String> names, ArrayList<String> icons) {
        player1.setName(names.get(0));
        player2.setName(names.get(1));
        player1.setSymbol(icons.get(0));
        player2.setSymbol(icons.get(1));
    }

    public static TikTakToe getTikTakToe() {
        return game;
    }

    public static boolean checkBoard(String value) {
        // check diagonals
        if (checkDiagonals(value) == true) {
            // handle winning
            return true;
        }
        // check horizontals
        if (checkHorizontals(value) == true) {
            // handle winning
            return true;
        }
        // check verticals
        if (checkVerticals(value) == true) {
            // handle winning
            return true;
        }
        if (total_turns > 10) {
            // handle tie event
        }
        // continue game
        return false;
    }

    public static void takeTurn1() {
        // find location from String input
        System.out.println("\n\n\n" + inputX + inputY + "\n\n\n\"");
        gameboard[inputX][inputY] = X;
        total_turns++;
        if (checkBoard(X)){
            //update controller
            Controller.gameOver(player1);
        }
    }

    public static void takeTurn2() {
        // find location from String input
        gameboard[inputX][inputY] = O;
        total_turns++;
        if (checkBoard(O)){
            //update controller
            Controller.gameOver(player2);
        }
    }

    public static boolean checkDiagonals(String value) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][i] == value) {
                counter++;
            }
        }
        if (counter == 3) {
            return true;
        }
        counter = 0;

        if (gameboard[0][2] == value && gameboard[1][1] == value && gameboard[2][0] == value) {
            return true;
        }
        return false;
    }

    public static boolean checkHorizontals(String value) {
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int k = 0; k < 3; k++) {
                if (gameboard[i][k] == value) {
                    counter++;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkVerticals(String value) {
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int k = 0; k < 3; k++) {
                if (gameboard[k][i] == value) {
                    counter++;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                gameboard[i][k] = "ben&zephren";
            }
        }
    }

    // deciphers buttonid string to corresponding tile in order to update gameboard
    public static void convertInput(String s) {
        int i = Integer.parseInt(s);
        if (i == 0) {
            inputX = 0;
            inputY = 0;
        }
        if (i == 1) {
            inputX = 0;
            inputY = 1;
        }
        if (i == 2) {
            inputX = 0;
            inputY = 2;
        }
        if (i == 3) {
            inputX = 1;
            inputY = 0;
        }
        if (i == 4) {
            inputX = 1;
            inputY = 1;
        }
        if (i == 5) {
            inputX = 1;
            inputY = 2;
        }
        if (i == 6) {
            inputX = 2;
            inputY = 0;
        }
        if (i == 7) {
            inputX = 2;
            inputY = 1;
        }
        if (i == 8) {
            inputX = 2;
            inputY = 2;
        }
    }
}