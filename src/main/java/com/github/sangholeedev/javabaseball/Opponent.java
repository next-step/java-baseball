package com.github.sangholeedev.javabaseball;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Opponent {
    private int baseballNumber = 0;

    private Opponent() {
        generate3Number();
    }

    private static class OpponentInstanceClazz {
        private static final Opponent instance = new Opponent();
    }

    public static Opponent getInstance() {
        return OpponentInstanceClazz.instance;
    }

    private int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    public void generate3Number() {
        Set<Integer> numberSet = new LinkedHashSet<>();

        while (numberSet.size() < 3) {
            numberSet.add(generateNumber());
        }

        int power = 0;
        for (Integer number : numberSet) {
            baseballNumber += number * Math.pow(10, power);
            ++power;
        }
    }

    public int getBaseballNumber() {
        return baseballNumber;
    }
}
