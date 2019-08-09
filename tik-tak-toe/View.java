package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {
    ArrayList<ArrayList<Button>> buttons = new ArrayList<ArrayList<Button>>();
    int defaultX = 50;
    int defaultY = 50;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Controller c = root.getController();

        primaryStage.setTitle("Tik-Tak-Toe");
        Pane layout = new Pane();

        layout.setStyle("-fx-background-color: #87CEFA;");

        ArrayList<Button> RowA = new ArrayList<Button>();
        ArrayList<Button> RowB = new ArrayList<Button>();
        ArrayList<Button> RowC = new ArrayList<Button>();

        for (int i = 0; i < 3; i++) {
            RowA.add(new Button("       "));
            RowA.get(i).setLayoutX((defaultX * i + 65));
            RowA.get(i).setLayoutY((defaultY * 1 + 65));
            layout.getChildren().add(RowA.get(i));
            //RowA.get(i).setOnAction(buttonHandler);

            RowB.add(new Button("       "));
            RowB.get(i).setLayoutX((defaultX * i + 65));
            RowB.get(i).setLayoutY((defaultY * 2 + 65));
            layout.getChildren().add(RowB.get(i));
//            RowB.get(i).setOnAction(buttonHandler);

            RowC.add(new Button("       "));
            RowC.get(i).setLayoutX((defaultX * i + 65));
            RowC.get(i).setLayoutY((defaultY * 3 + 65));
            layout.getChildren().add(RowC.get(i));
//            RowC.get(i).setOnAction(buttonHandler);
        }

        buttons.add(RowA);
        buttons.add(RowB);
        buttons.add(RowC);

        primaryStage.setScene(new Scene(layout, 300, 300));
        primaryStage.show();

    }

    public static String getPlayer() {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name: ");

        dialog.showAndWait();

        return dialog.getEditor().getText();

    }

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