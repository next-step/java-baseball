import controller.GameController;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);
        gameController.play();
    }
}
