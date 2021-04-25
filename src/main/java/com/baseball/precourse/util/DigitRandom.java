package com.baseball.precourse.baseball.util;

import java.util.Random;

public class DigitRandom {
    public static final int MAX_RANDOM_LENGTH = 9;

    public String generateRandom(final int length){
        if ( length > MAX_RANDOM_LENGTH) {
            throw new IllegalArgumentException(String.format("Maximum length of random is %d",MAX_RANDOM_LENGTH));
        }
        StringBuffer buffer = new StringBuffer();
        while(buffer.length() < length){
            addRandom(buffer, randomDigit());
        }
        return buffer.toString();
    }

    public static String generate(int length) {
        DigitRandom random = new DigitRandom();
        return random.generateRandom(length);
    }

    private StringBuffer addRandom(StringBuffer buffer, String digit){
        if(buffer.indexOf(digit) < 0){
            return buffer.append(digit);
        }
        return buffer;
    }

    private String randomDigit() {
        Random random = new Random();
        final int number = random.ints(1, (9)).findFirst().getAsInt();
        return String.valueOf(number);
    }
}