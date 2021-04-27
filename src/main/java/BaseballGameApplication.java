import baseball.controller.BaseballController;
import baseball.controller.dto.BaseballGameResponse;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameApplication {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BaseballController controller = new BaseballController();

    public static void main(String[] args) {
        do {
            controller.start();
            executeGame();
        } while (inputView.inputContinue());
    }

    private static void executeGame() {
        BaseballGameResponse gameResponse;
        do {
            gameResponse = controller.pitch(inputView.inputGameRequest());
            outputView.printGameRecord(gameResponse);
        } while (!gameResponse.isFinished());
    }
}
