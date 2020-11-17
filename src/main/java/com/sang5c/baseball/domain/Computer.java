package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static BaseBall randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i <= Number.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return BaseBall.of(numbers.subList(0, BaseBall.BASEBALL_NUMBERS_LENGTH));
    }
}
