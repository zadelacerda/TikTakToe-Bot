package sample;

//import javax.swing.*;

import static javafx.application.Application.launch;

/**
 * Zephren de la Cerda
 * Tik-Tak-Toe
 * 6/7/2019
 *
 **/
public class TikTakToe {

    public static String[][] gameboard;
    public static String player1;
    public static String player2;
    public static String X = "X";
    public static String O = "O";


//    public static void main(String[] args) {
//        //launch(args);
//        gameboard = new String[3][3];
//        initBoard();
//        String currPlayer;
////        player1 = JOptionPane.showInputDialog("Player 1: enter your name.");
////        player2 = JOptionPane.showInputDialog("Player 2: enter your name.");
//        printBoard();
//        int total_turns = 0;
//        while (total_turns < 10) {
//            takeTurn(player1);
//            if (checkBoard(X)) {
//                //player1 wins congrats
//                System.out.println("Congrats! " + player1 + " you win!");
//                System.exit(0);
//            }
//            total_turns++;
//            printBoard();
//
//            takeTurn(player2);
//            if (checkBoard(O)) {
//                //player2 wins xDDDD
//                System.out.println("Congrats! " + player2 + " you win!");
//                System.exit(0);
//            }
//            total_turns++;
//            printBoard();
//        }
//    }

    public static boolean checkBoard(String value) {
        //check diagonals
        if (checkDiagonals(value) == true)
            return true;

        //check horizontals
        if (checkHorizontals(value) == true)
            return true;

        //check verticals
        if (checkVerticals(value) == true)
            return true;

        return false;

    }

    public static void takeTurn(String player) {
//        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter which column: (1-3)")) - 1;
//        int y = Integer.parseInt(JOptionPane.showInputDialog("Enter which row: (1-3)")) - 1;

//        if (player == player1) {
//            gameboard[x][y] = X;
//        } else if (player == player2) {
//            gameboard[x][y] = O;
//        }
    }

    public static boolean checkDiagonals(String value) {
        int counter = 0;
        for (int i = 0; i < 3; i++){
            if (gameboard[i][i] == value){
                counter++;
            }
        }
        if (counter == 3){
            return true;
        }
        counter = 0;

        if (gameboard[0][2] == value && gameboard[1][1] == value && gameboard[2][0] == value){
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

    public static void printBoard(){
        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 3; k++){
                System.out.print(" " + gameboard[i][k] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        System.out.println("");
    }

    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                gameboard[i][k] = "zephren";
            }
        }
    }

    public static void initPlayers(String p1, String p2){
        player1 = p1;
        player2 = p2;
    }
}