import domain.Number;
import util.NumberUtil;
import view.Input;

public class BaseballGame {
    private static final Input input = new Input();

    BaseballGame() {
    }

    public void play() {
        boolean isContinue = false;

        do {
            isContinue = start();
        } while (isContinue);
    }

    public boolean start() {
        Number randomNumber = NumberUtil.generateRandomNumber();
        boolean isSolved = false;

        do {
            String inputNumber = input.threeNumber();
            isSolved = true;
        } while (!isSolved);

        return askContinueGame();
    }

    private boolean askContinueGame() {
        return false;
    }
}
