package sample;

public class Driver {
    public static void main(String[] args){
        TikTakToe model = new TikTakToe();
        View view = new View();
        Controller controller = new Controller(model, main);

        controller.setMain();
    }
}
