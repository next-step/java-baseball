package domain;

import java.util.List;

public class BaseballNumbers {

    private static final String INVALID_BASEBALL_NUMBER_SIZE = "잘못된 베이스볼 숫자 갯수입니다.";
    private static final String INVALID_BASEBALL_NUMBER_RANGE = "베이스볼 숫자는 1~9 사이의 정수여야합니다.";
    private static final int BASEBALL_NUMBER_SIZE = 3;

    private List<Integer> numbers;

    private BaseballNumbers() {
    }

    private BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;

        validation(numbers);
    }

    private void validation(List<Integer> numbers) {
        checkNumbersSize(numbers);

        for (int number : numbers) {
            checkRange(number);
        }
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBER_SIZE);
        }
    }

    private void checkRange(int number) {
        if(number < 1 || number  > 9) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBER_RANGE);
        }
    }

    public static BaseballNumbers create(List<Integer> numbers) {
        return new BaseballNumbers(numbers);
    }

    public boolean contains(int playerNumber) {
        return numbers.contains(playerNumber);
    }

    public int numberOfRound(int round) {
        return numbers.get(round - 1);
    }

    public boolean isSameIndex(Pitching pitching) {
        return (numbers.indexOf(pitching.pitching()) + 1) == pitching.pitchingSequence();
    }
}
