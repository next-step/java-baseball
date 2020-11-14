package domain;

import utils.RandomUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerNumber {
    private static final int NUMBER_LENGTH = 3;
    private final String number;

    public ComputerNumber() {
        this.number = makeRandomNumber();
    }

    private String makeRandomNumber() {
        Set<String> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < NUMBER_LENGTH) {
            numberSet.add(String.valueOf(RandomUtils.random()));
        }
        return String.join("", numberSet);
    }

    public String getNumber() {
        return number;
    }
}
