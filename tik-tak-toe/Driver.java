package sample;

public class Driver {
    public static void main(String[] args) {
        TikTakToe model = new TikTakToe();
        View view = new View();
        Controller controller = new Controller(model, main);

        controller.setMain();
    }

    // /* this functions belongs in view.java */
    // // sets button ids to integer values 0-8, left to right top to bottom gameboard
    // // tiles
    // private static void setButtonIds(Button b) {
    //     for (int i = 0; i < 3; i++) {
    //         for (int j = 0; j < 3; j++) {
    //             buttons[i][j].setId(Integer.toString(i)); // inherited from Node.java
    //         }
    //     }
    // }

    /* add this line to the buttonhandler*/

    
}
