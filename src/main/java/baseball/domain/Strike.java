package baseball.domain;

import baseball.constants.Constants;

import java.util.List;

public class Strike {
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
            plusCount(answer.getAnswer().get(i), baseballNumbers.get(i));
        }
    }

    private void plusCount(final BaseballNumber answerNumber, final BaseballNumber inputNumber) {
        if (answerNumber.equals(inputNumber)) {
            this.count++;
        }
    }

    public void initCount() {
        this.count = INIT_COUNT;
    }

    public int getCount() {
        return count;
    }
}
