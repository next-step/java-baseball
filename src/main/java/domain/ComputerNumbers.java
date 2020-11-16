package domain;

import utils.RandomUtils;

import java.util.*;

public class ComputerNumbers {
    private static final int NUMBER_LENGTH = 3;
    private final Set<BaseballNumber> computerNumbers;

    public ComputerNumbers() {
        this.computerNumbers = new LinkedHashSet<>();
        makeRandomNumbers();
    }

    private void makeRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_LENGTH) {
            numbers.add(RandomUtils.random());
        }

        int position = 0;
        for (int number : numbers) {
            computerNumbers.add(new BaseballNumber(new Order(position), number));
            position += 1;
        }
    }

    public Set<BaseballNumber> getComputerNumbers() {
        return computerNumbers;
    }
}
