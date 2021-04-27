package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.domain.Score;
import baseball.util.BaseballException;
import baseball.util.BaseballNumberFactory;

public class BaseballService {
    private BaseballNumberFactory baseballNumberFactory;

    public BaseballService() {
        this.baseballNumberFactory = new BaseballNumberFactory();
    }

    public BaseballNumbers generateAnswer() {
        return this.baseballNumberFactory.generateNumbers();
    }

    public Score scorePlayerInput(BaseballNumbers answer, String playerInput) {
        Score score = new Score();

        try {
            BaseballNumbers playerBaseballNumber = new BaseballNumbers(playerInput);
            score = Score.measureScore(answer, playerBaseballNumber);
        } catch (BaseballException e) {
            System.out.println(e.getMessage());
            score = Score.createErrorStateScore();
        }

        return score;
    }
}
