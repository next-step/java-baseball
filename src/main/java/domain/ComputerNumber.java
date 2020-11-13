package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private String number;

    public ComputerNumber() {
        this.number = makeRandomNumber();
    }

    private String makeRandomNumber() {
        Set<String> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < NUMBER_LENGTH) {
            int randomNumber = (int) (MIN_NUMBER + Math.random() * MAX_NUMBER);
            numberSet.add(String.valueOf(randomNumber));
        }
        return String.join("", numberSet);
    }

    public String getNumber() {
        return number;
    }
}
