package com.baseball.domain.baseballnumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberRandomGenerator implements BaseballNumberGenerator {

    @Override
    public BaseballNumber generate() {
        List<Integer> random = new ArrayList<>(createRandomNumber());
        return new BaseballNumber(random);
    }

    private Set<Integer> createRandomNumber() {
        Set<Integer> nonDuplicateNumbers = new HashSet<>();
        while(nonDuplicateNumbers.size() != BaseballNumber.SIZE) {
            int random = (int) (Math.random() * 9 + 1);
            nonDuplicateNumbers.add(random);
        }
        return nonDuplicateNumbers;
    }
}
