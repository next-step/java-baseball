package io.mwkwon.baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BaseBallGame {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int MAX_VALUE_LENGTH = 3;

    public String createComputerNumbers() {
        Random random = new Random();
        Set<String> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() < MAX_VALUE_LENGTH) {
            int number = random.nextInt(MAX_VALUE) + MIN_VALUE;
            computerNumbers.add(String.valueOf(number));
        }
        return String.join("", computerNumbers);
    }
}
