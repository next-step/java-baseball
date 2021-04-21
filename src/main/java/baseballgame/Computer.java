package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    final int minNumber = 1;
    final int maxNumber = 9;
    final int numberCount = 3;
    List<Integer> numbers = new ArrayList<>();

    private void selectNumber() {
        while(numbers.size() < numberCount) {
            numbers.add(generateRandNumber());
        }
    }

    private int generateRandNumber() {
        Random random = new Random();
        return random.nextInt(maxNumber) + minNumber;
    }
}
