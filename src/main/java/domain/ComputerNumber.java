package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> numbers;

    public ComputerNumber() {
        this.numbers = makeRandomNumbers();
    }

    private List<Integer> makeRandomNumbers() {
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < NUMBER_LENGTH) {
            numberSet.add(RandomUtils.random());
        }
        return new ArrayList<>(numberSet);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
