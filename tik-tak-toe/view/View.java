
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Optional;

public class View extends Application {
    ArrayList<ArrayList<Button>> buttons = new ArrayList<ArrayList<Button>>();
    int defaultX = 50;
    int defaultY = 50;

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
        grid.setStyle("-fx-background-color: BLACK");
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPrefHeight(54);
        grid.setPrefWidth(54);
        grid.setHgap(3);
        grid.setVgap(3);

        ArrayList<Button> RowA = new ArrayList<Button>();
        ArrayList<Button> RowB = new ArrayList<Button>();
        ArrayList<Button> RowC = new ArrayList<Button>();

        //Custom button handler
        class ButtonHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event){
                /* When button is clicked */
                Button button = (Button) event.getSource();
                button.setText("boop");
            }
        }

        //Add buttons to grid
        ButtonHandler buttonHandler = new ButtonHandler();
        for (int i = 0; i < 3; i++) {
            RowA.add(new Button("       "));
            RowA.get(i).setPrefSize(120, 120);
            RowA.get(i).setOnAction(buttonHandler);
            grid.add(RowA.get(i), i, 1);

            RowB.add(new Button("       "));
            RowB.get(i).setPrefSize(120, 120);
            RowB.get(i).setOnAction(buttonHandler);
            grid.add(RowB.get(i), i, 2);

            RowC.add(new Button("       "));
            RowC.get(i).setPrefSize(120, 120);
            RowC.get(i).setOnAction(buttonHandler);
            grid.add(RowC.get(i), i, 3);
        }
        
        // setButtonText();
        buttons.add(RowA);
        buttons.add(RowB);
        buttons.add(RowC);

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

    // }

    public void addButtonAction(EventHandler<ActionEvent> action) {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                System.out.println(i + " "+ k);
                buttons.get(i).get(k).setOnAction(action);
                System.out.println("Hello");
            }
        }
    }
}