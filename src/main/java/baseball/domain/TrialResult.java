package baseball.domain;

import baseball.service.TrialResultCalculator;
import baseball.validator.TrialResultValidator;
import baseball.validator.Validatable;

import static baseball.domain.NumberResult.BALL;
import static baseball.domain.NumberResult.STRIKE;
import static baseball.validator.InputNumbersValidator.GAME_NUMBER_COUNT;

public class TrialResult {
    public static final String FINISH_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING_MESSAGE = "낫싱";

    private static final Validatable<Integer> validator = new TrialResultValidator();

    private final int strikeCount;
    private final int ballCount;

    public TrialResult(int strikeCount, int ballCount) {
        validator.validate(strikeCount + ballCount);

        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public TrialResult(TrialResultCalculator trialResultCalculator) {
        this(
            trialResultCalculator.getOrDefault(STRIKE, 0),
            trialResultCalculator.getOrDefault(BALL, 0)
        );
    }

    @Override
    public String toString() {
        if (strikeCount <= 0 && ballCount <= 0) {
            return NOTHING_MESSAGE;
        }

        if (finished()) {
            return strikeCount + FINISH_MESSAGE;
        }

        return getMatchedResultString();
    }

    String getMatchedResultString() {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0)
            sb.append(strikeCount + " " + STRIKE.getText() + " ");

        if (ballCount > 0)
            sb.append(ballCount + " " + BALL.getText());

        return sb.toString();
    }

    public boolean finished() {
        return strikeCount == GAME_NUMBER_COUNT;
    }
}
