import domain.BaseballGameMachine;
import view.InputView;

public class BaseballGameApp {
    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();

        while (baseballGameMachine.isBaseballGameContinue()) {
            InputView.guess(baseballGameMachine);

            int continueInput = InputView.inputContinueNumber();
            baseballGameMachine.continueGameByInput(continueInput);
        }
    }
}
