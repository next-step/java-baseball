import domain.BaseballGameMachine;

public class BaseballGameApp {
    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();
        while (baseballGameMachine.isBaseballGameContinue()) {
            baseballGameMachine.guessIteration();
            baseballGameMachine.continueGameByInput();
        }
    }
}
