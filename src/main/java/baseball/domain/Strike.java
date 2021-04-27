package baseball.domain;

import baseball.constants.Constants;

import java.util.List;
import java.util.Objects;

public class Strike {
    private static final int ALL_STRIKE_COUNT = 3;
    private static final int INIT_COUNT = 0;

    private int count;

    private Strike() {
        this.count = INIT_COUNT;
    }

    public static Strike newInstance() {
        return new Strike();
    }

    public void countStrike(final Answer answer, final List<BaseballNumber> baseballNumbers) {
        for (int i = 0; i < Constants.BASEBALL_NUMBER_SIZE; i++) {
            BaseballNumber answerNumber = answer.getAnswer(i);
            BaseballNumber inputNumber = baseballNumbers.get(i);
            boolean isStrike = answerNumber.equals(inputNumber);
            plusCount(isStrike);
        }
    }

    private void plusCount(final boolean isStrike) {
        if (isStrike) {
            this.count++;
        }
    }

    public void initCount() {
        this.count = INIT_COUNT;
    }

    public boolean isAllStrike() {
        return count == ALL_STRIKE_COUNT;
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
        Strike strike = (Strike) o;
        return count == strike.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
