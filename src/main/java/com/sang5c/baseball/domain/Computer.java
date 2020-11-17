package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static Numbers randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return Numbers.of(numbers.subList(0, 3));
    }
}
