import java.util.*;

public class Controller{
    private static TikTakToe game;
    private static View view;
    private static Controller controller = new Controller();

    private Controller(){
        game = TikTakToe.newGame(); // lazy initialization/singleton
        view = new View();
        // view.startGame();
    }
}