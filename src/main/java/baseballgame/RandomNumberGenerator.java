package baseballgame;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private List<Integer> numbers = new ArrayList<>();

    public RandomNumber generateRandomNumber() {
        while(numbers.size() <= 3) {
            Integer number = (int)(Math.random() * 9) + 1;
            addNumber(number);
        }
        return new RandomNumber(numbers);
    }

    private void addNumber(Integer number) {
        if(!numbers.contains(number)) numbers.add(number);
    }
}
