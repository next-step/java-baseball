package com.game.baseball;

import java.util.Random;
import java.util.Set;

public class Question extends Dataset {

    public Set<Integer> make(int length) {
        resetData();

        while (getDataSize() < length) {
            add(getRandomSingleNumber());
        }

        return getData();
    }

    private Integer getRandomSingleNumber() {
        return new Random().nextInt(8) + 1;
    }

}
