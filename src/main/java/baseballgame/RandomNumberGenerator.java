package baseballgame;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;
    private final int NUMBER_LENGTH = 3;
    private List<Integer> numbers = new ArrayList<>();

    public RandomNumber generateRandomNumber() {
        while(numbers.size() < NUMBER_LENGTH) {
            Integer number = (int)(Math.random() * MAX_NUMBER) + MIN_NUMBER;
            addNumber(number);
        }
        return new RandomNumber(numbers);
    }

    private void addNumber(Integer number) {
        if(!numbers.contains(number)) numbers.add(number);
    }
}
