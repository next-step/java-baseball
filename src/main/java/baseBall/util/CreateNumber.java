package baseBall.util;

import java.util.Random;

public class CreateNumber {

    private final int MAX_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public String generateRandomNumber() {
        Random random = new Random();
        return String.valueOf(random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
    }

    public StringBuilder generateNumbers() {
        StringBuilder numbers = new StringBuilder();
        while(numbers.length() < MAX_LENGTH) {

            String temp = generateRandomNumber();

            if (numbers.indexOf(temp) == -1) {
                numbers.append(temp);
            }
        }

        return numbers;
    }

}
