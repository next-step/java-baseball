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
            BaseballNumber answerNumber = answer.getAnswer(i);
            BaseballNumber inputNumber = baseballNumbers.get(i);
            boolean isBall = !answerNumber.equals(inputNumber) && baseballNumbers.contains(answerNumber);
            plusCount(isBall);
        }
    }

    private void plusCount(boolean isBall) {
        if (isBall) {
            this.count++;
        }
    }

    public void initCount() {
        this.count = INIT_COUNT;
    }

    public boolean isNothing() {
        return count == INIT_COUNT;
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
