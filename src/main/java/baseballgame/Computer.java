package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    public void selectNumber() {
        initSelectedNumber();
        while(numbers.size() < Const.NUMBER_COUNT) {
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
        return random.nextInt(Const.MAX_NUMBER) + Const.MIN_NUMBER;
    }

    private void addNumber(int number) {
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }
}
