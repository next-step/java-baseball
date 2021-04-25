package com.tistory.javapanda.baseball.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomGenerator {

    private RandomGenerator() {}

    private static int getNumber() throws NoSuchAlgorithmException {
        return SecureRandom.getInstance("SHA1PRNG").nextInt(9) + 1;
    }

    public static Set<Integer> getNumbers() throws NoSuchAlgorithmException {
        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 3) {
            int number = getNumber();
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
        return computerNumbers;
    }

}
