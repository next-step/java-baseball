import domain.Number;
import domain.ScoreMatch;
import util.NumberUtil;
import view.Input;

public class BaseballGame {
    private static final Input input = new Input();

    BaseballGame() {
    }

    public void start() {
        boolean isContinue = false;

        do {
            isContinue = play();
        } while (isContinue);
    }

    public boolean play() {
        Number randomNumber = NumberUtil.generateRandomNumber();
        ScoreMatch scoreMatch = new ScoreMatch(randomNumber);
        boolean isSolved = false;

        do {
            isSolved = scoreMatch.compare(input.number());
        } while (!isSolved);

        return input.askContinueGame();
    }
}
