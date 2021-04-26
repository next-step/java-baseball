package com.tistory.javapanda.baseball.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> getNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int number = getNumber();
            for (int n : computerNumbers) {
                if(number == n) {
                    continue;
                }
            }
            computerNumbers.add(number);
        }
        return computerNumbers;
    }

}
