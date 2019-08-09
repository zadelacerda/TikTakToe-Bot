package sample;

public class Driver {
    public static void main(String[] args){
        TikTakToe model = new TikTakToe();
        Main main = new Main();
        Controller controller = new Controller(model, main);

        controller.setMain();
    }
}
