
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
import javafx.scene.control.Button;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.effect.*;

import java.util.ArrayList;
import java.util.Optional;

public class View extends Application {
    Button[][] buttons = new Button[3][3];
    Boolean turn = false;
    public static void main(String[] args) {
        launch(args);
    }   

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tik-Tak-Toe");

        //StackPane to center the grid on the scene
        StackPane layout = new StackPane();

        //Scene to hold the grid
        Scene scene = new Scene(layout, 600, 600);
        layout.setStyle("-fx-background-color: #87CEFA;");

        //Grid holds buttons 
        GridPane grid = new GridPane();
        layout.getChildren().add(grid);
        grid.setStyle("-fx-background-color: #F08080;");
        grid.setPadding(new Insets(50, 10, 10, 10));
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPrefHeight(54);
        grid.setPrefWidth(54);
        grid.setHgap(3);
        grid.setVgap(3);

        //Custom button handler
        class ButtonHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event){
                /* When button is clicked */
                Button button = (Button) event.getSource();
                // button.setText("boop");
                if (turn){
                    button.setGraphic(new ImageView("/images/waffle.jpg"){{
                        setFitWidth(100);
                        setFitHeight(100);
                    }});
                    turn = false;
                } else {
                    button.setGraphic(new ImageView("/images/pancake.jpg"){{
                        setFitWidth(100);
                        setFitHeight(100);
                    }});
                    turn = true;
                }
            }
        }

        DropShadow shadow = new DropShadow();
        ButtonHandler buttonHandler = new ButtonHandler();

        //Add buttons to grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
            buttons[i][j] = new Button("");
            buttons[i][j].setPrefSize(120, 120);
            buttons[i][j].setOnAction(buttonHandler);
            buttons[i][j].setStyle("-fx-background-color: #DC143C;");
            buttons[i][j].addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    Button button = (Button) e.getSource();
                    button.setEffect(shadow);
                }});
            buttons[i][j].addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    Button button = (Button) e.getSource();
                    button.setEffect(null);
                }});
            grid.add(buttons[i][j], i, j + 10);
            }
        }
        
        Text nextPlayer = new Text("Player1: Your Turn.");
        grid.add(nextPlayer, 1, 0);
        primaryStage.setScene(scene);
        primaryStage.show();

        // player1.name = getPlayer();
        // player2.name = getPlayer();


    }

    public static String getPlayerName() {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name: ");

        dialog.showAndWait();

        return dialog.getEditor().getText();

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