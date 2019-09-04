package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;   
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;

// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.effect.*;

import java.util.ArrayList;
import java.util.Optional;

import controller.Controller;

public class View extends Application {
    static Button[][] buttons = new Button[3][3];
    static int turnCounter = 0;
    
    static Boolean player1 = true;
    static Boolean player2 = false;
    static Boolean turn = player1;

    // public static void main(String[] args) {
    //     launch(args);
    // }   

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tik-Tak-Toe");

        //StackPane to center the grid on the scene
        StackPane layout = new StackPane();

        /* Scene to hold the grid */
        Scene scene = new Scene(layout, 600, 600);
        layout.setStyle("-fx-background-color: #87CEFA;");

        /* Grid that holds buttons */
        GridPane grid = new GridPane();
        layout.getChildren().add(grid);
        grid.setStyle("-fx-background-color: #F08080;");
        grid.setPadding(new Insets(50, 10, 10, 10));
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPrefHeight(54);
        grid.setPrefWidth(54);
        grid.setHgap(3);
        grid.setVgap(3);


        initButtons(grid);
        

        /* Reset Button */
        Button resetButton = new Button("RESET");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                initButtons(grid);
            }
        });
        resetButton.setStyle("-fx-background-color: #DC143C;");
        resetButton.setPrefSize(100, 40);
        addShadow(resetButton);
        grid.add(resetButton, 2, 0);

        
        setPlayerText(grid);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void initButtons(GridPane grid){
      
         /* Custom Button Handler */
         class ButtonHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event){
                /* When button is clicked - add pictures to buttons */
                Button button = (Button) event.getSource();
                if (turn){
                    /* First players turn */
                    // button.setGraphic(new ImageView("/images/waffles.png"){{
                    //     setFitWidth(100);
                    //     setFitHeight(100);
                    // }});
                    button.setText("X");
                    turn = player2;
                } else {
                    /* Second players turn */
                    // button.setGraphic(new ImageView("/images/pancake.png"){{
                    //     setFitWidth(100);
                    //     setFitHeight(100);
                    // }});
                    button.setText("O");        
                    turn = player1;
                }
                button.setDisable(true); 
                turnCounter++;
                setPlayerText(grid);
                Controller.gameButtonPressed(turn, button.getId());
            }
        }
        
        ButtonHandler buttonHandler = new ButtonHandler();
        int buttonCounter = 0;
        /* Add Buttons to Grid */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                buttons[i][j] = new Button("");
                buttons[i][j].setPrefSize(120, 120);
                buttons[i][j].setOnAction(buttonHandler);
                buttons[i][j].setStyle("-fx-background-color: #DC143C;");
                addShadow(buttons[i][j]);
                buttons[i][j].setId(Integer.toString(i));
                grid.add(buttons[i][j], i, j + 10);
                buttons[i][j].setId(Integer.toString(buttonCounter));
                buttonCounter++;
            }
        }
    }


    public static String getPlayerName() {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name: ");

        dialog.showAndWait();

        return dialog.getEditor().getText();
    }


    public static void setPlayerText(GridPane grid){
        String currPlayer = "Test";
        if (turn){
            //currPlayer = player1.name;
        } else {
            //currPlayer = player2.name
        }

        /* Next Player Text */
        Text nextPlayer = new Text(currPlayer + ": Your Turn.");
        grid.add(nextPlayer, 1, 0);
        
    }


    public static void addShadow(Button button){
        DropShadow shadow = new DropShadow();

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    Button button = (Button) e.getSource();
                    button.setEffect(shadow);
                }});
        button.addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    Button button = (Button) e.getSource();
                    button.setEffect(null);
                }});
    }

    public static void showWinner(String winner){
        //pop up window displays winner
        //game is over
        //reset game after "ok"
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setHeaderText("WINNER IS X");
        dialog.setContentText("WINNER: ");

        dialog.showAndWait();
    }

    //DO LATER: have player select their own symbol from given list
    // public static String getPlayerSymbol() {
    //     TextInputDialog dialog = new TextInputDialog("");

    //     dialog.setHeaderText("Select your symbol:");
    //     dialog.setContentText("Name: ");

    //     dialog.showAndWait();

    //     return dialog.getEditor().getText();

    //}
}