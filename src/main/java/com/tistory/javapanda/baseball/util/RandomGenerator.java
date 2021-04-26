package com.tistory.javapanda.baseball.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomGenerator {

    private RandomGenerator() {}

    public static int getNumber() {
        int number = 0;
        try {
            number = SecureRandom.getInstance("SHA1PRNG").nextInt(9) + 1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static Set<Integer> getNumbers() {
        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 3) {
            computerNumbers.add(getNumber());
        }
        return computerNumbers;
    }

}
