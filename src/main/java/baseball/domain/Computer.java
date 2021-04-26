package baseball.domain;

import baseball.constants.Constants;
import baseball.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final String INVALID_SIZE_MESSAGE = String.format("%s자리 숫자를 입력하셔야 합니다.",
            Constants.BASEBALL_NUMBER_SIZE);
    private static final String INVALID_DUPLICATE_MESSAGE = "중복된 숫자는 입력하실 수 없습니다.";

    private final Answer answer;
    private final Score score;

    private Computer(final Answer answer) {
        this.answer = answer;
        this.score = Score.newInstance();
    }

    public static Computer from(final NumberGenerator numberGenerator) {
        Answer answer = Answer.from(numberGenerator);
        return new Computer(answer);
    }

    public void play(final List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            baseballNumbers.add(BaseballNumber.from(number));
        }
        countScore(baseballNumbers);
    }

    private void checkSize(final List<Integer> numbers) {
        if (numbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void checkDuplicate(final List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_MESSAGE);
        }
    }

    private void countScore(final List<BaseballNumber> baseballNumbers) {
        score.initScore();
        score.countScore(answer, baseballNumbers);
    }

    public boolean isAllStrike() {
        return score.isAllStrike();
    }

    public int getStrike() {
        return score.getStrike();
    }

    public int getBall() {
        return score.getBall();
    }
}
