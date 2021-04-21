package com.woowahan.pro.opponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerOpponent implements Opponent{
    public static final String[] RANDOM_NUMBER_RANGE = new String[]{"1","2","3","4","5","6","7","8","9"};

    @Override
    public String[] createRandomNumber() {
        List<String> numbers = Arrays.asList(RANDOM_NUMBER_RANGE);
        Collections.shuffle(numbers);

        String[] retNumbers = new String[]{numbers.get(0), numbers.get(1), numbers.get(2)};

        return retNumbers;
    }
}
