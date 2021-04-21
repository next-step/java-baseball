import domain.Number;
import util.NumberUtil;

public class BaseballGame {
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
            isSolved = true;
        } while (!isSolved);

        return askContinueGame();
    }

    public boolean askContinueGame() {
        return false;
    }
}
