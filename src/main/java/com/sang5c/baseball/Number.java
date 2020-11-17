package com.sang5c.baseball;

public class Number {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("out of range: " + number);
        }
    }


}
