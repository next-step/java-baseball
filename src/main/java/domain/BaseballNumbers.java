package domain;

import java.util.*;

public class BaseballNumbers {
    private static final int NUMBER_LENGTH = 3;

    private final Set<BaseballNumber> baseballNumbers;

    public BaseballNumbers(final Map<Integer, Integer> numbers) {
        validate(numbers);

        this.baseballNumbers = new LinkedHashSet<>();
        convertToBaseballNumbers(numbers);
    }

    public Score compareNumbers(final BaseballNumber otherBaseballNumber) {
        Score score = Score.NOTHING;
        for(BaseballNumber baseballNumber : baseballNumbers) {
            Score newScore = baseballNumber.compareNumber(otherBaseballNumber);
            score = judgeScore(score, newScore);
        }
        return score;
    }

    private void validate(final Map<Integer, Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되지 않은 숫자로 " + NUMBER_LENGTH + "개 입력해주세요.");
        }
    }

    private void convertToBaseballNumbers(final Map<Integer, Integer> numbers) {
        numbers.forEach((number, index) -> baseballNumbers.add(new BaseballNumber(new Order(index), number)));
    }

    private Score judgeScore(final Score score, final Score newScore) {
        if (newScore != Score.NOTHING) {
            return newScore;
        }
        return score;
    }
}
