package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private final int minNumber = 1;
    private final int maxNumber = 9;
    private final int numberCount = 3;

    private List<Integer> numbers = new ArrayList<>();

    public void selectNumber() {
        initSelectedNumber();
        while(numbers.size() < numberCount) {
            addNumber(generateRandNumber());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void initSelectedNumber() {
        this.numbers.clear();
    }

    private int generateRandNumber() {
        Random random = new Random();
        return random.nextInt(maxNumber) + minNumber;
    }

    private void addNumber(int number) {
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }
}
