import domain.*;
import view.InputView;

public class BaseballGameApp {
    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();
        while (baseballGameMachine.isBaseballGameContinue()) {
            baseballGameMachine.startGuessIteration();
            baseballGameMachine.continueGameByInput();
        }
    }
}
