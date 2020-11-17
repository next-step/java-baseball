package game.baseball.number.participants;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Pitcher {

    private static final Random RANDOM = new Random();
    private static final int START_OF_NUMBER = 1;
    private static final int NUMBER_BOUND = 9;
    private static final int NUMBER_COUNT = 3;

    String throwNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != NUMBER_COUNT) {
            numbers.add(RANDOM.nextInt(NUMBER_BOUND) + START_OF_NUMBER);
        }
        StringBuilder appendNumbers = new StringBuilder();
        for (Integer number : numbers) {
            appendNumbers.append(number);
        }
        return appendNumbers.toString();
    }
}
