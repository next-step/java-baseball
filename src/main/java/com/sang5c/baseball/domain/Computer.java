package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static Baseball randomBaseball() {
        List<Integer> list = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i < Number.MAX_NUMBER; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return Baseball.of(list.subList(0, Baseball.BASEBALL_NUMBER_LENGTH));
    }

}
