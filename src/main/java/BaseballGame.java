import domain.Number;
import domain.ScoreMatch;
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
        ScoreMatch scoreMatch = new ScoreMatch(randomNumber);
        boolean isSolved = false;

        do {
            isSolved = scoreMatch.compare(input.threeDigitNumber());
        } while (!isSolved);

        return input.askContinueGame();
    }
}
