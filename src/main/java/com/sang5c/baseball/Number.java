package com.sang5c.baseball;

public class Number {

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("out of range: " + number);
        }
    }

}
