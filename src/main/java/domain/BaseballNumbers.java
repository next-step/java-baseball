package domain;

import java.util.List;

public class BaseballNumbers {

    private static final String INVALID_BASEBALL_NUMBER_SIZE = "잘못된 베이스볼 숫자 갯수입니다.";
    private static final int BASEBALL_NUMBER_SIZE = 3;

    private List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;

        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBER_SIZE);
        }
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
