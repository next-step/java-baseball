package baseBall.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateNumber {

    private final int MAX_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while(numbers.size() < MAX_LENGTH) {
            int temp = generateRandomNumber();

            if (!numbers.contains(temp)) {
                numbers.add(temp);
            }
        }

        return numbers;
    }

}
