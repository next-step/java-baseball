package baseball.domain;

import baseball.constants.Constants;

import java.util.List;
import java.util.Objects;

public class Ball {
    private static final int INIT_COUNT = 0;

    private int count;

    private Ball() {
        this.count = INIT_COUNT;
    }

    public static Ball newInstance() {
        return new Ball();
    }

    public void countBall(final Answer answer, final List<BaseballNumber> baseballNumbers) {
        for (int i = 0; i < Constants.BASEBALL_NUMBER_SIZE; i++) {
            plusCount(answer.getAnswer(i), baseballNumbers, i);
        }
    }

    private void plusCount(final BaseballNumber answerNumber, final List<BaseballNumber> baseballNumbers, int index) {
        if (isBall(answerNumber, baseballNumbers, index)) {
            this.count++;
        }
    }

    private boolean isBall(final BaseballNumber answerNumber, final List<BaseballNumber> baseballNumbers, int index) {
        return !answerNumber.equals(baseballNumbers.get(index)) && baseballNumbers.contains(answerNumber);
    }

    public void initCount() {
        this.count = INIT_COUNT;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return count == ball.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
