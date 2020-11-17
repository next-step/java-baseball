package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static Baseball randomBaseball() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i <= Number.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return Baseball.of(numbers.subList(0, Baseball.BASEBALL_NUMBERS_LENGTH));
    }
}
