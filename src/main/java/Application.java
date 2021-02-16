import controller.Controller;
import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        Controller controller = new Controller(input, output);
        controller.play();
    }
}
