package baseball;

import util.RandomGenerator;

import java.util.Set;

public class BaseBallGame {
    private final Set<Integer> numbers;
    private int count = 0;

    public BaseBallGame(RandomGenerator randomGenerator) {
        numbers = randomGenerator.makeNumbersLessThanTen();
    }

    public String guess(String str) {
        int index = 0;
        for (Integer number : numbers) {
            Integer input = str.charAt(index) - '0';
            matchCheck(number, input);
            index++;
        }
        if (count == 0) {
            return BaseBall.NOTHING.getValue();
        }
        return "알수없음";
    }

    private void matchCheck(Integer number, Integer input) {
        if (number.equals(input)) {
            count++;
        }
    }
}
