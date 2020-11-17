package com.sang5c.baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    private final int number;

    private static final Map<Integer, Number> cache = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            cache.put(i, new Number(i));
        }
    }

    private Number(int number) {
        validate(number);
        this.number = number;
    }

    public static Number of(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("number null or empty");
        }
        return of(Integer.parseInt(number));
    }

    public static Number of(int number) {
        validate(number);
        return cache.get(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("out of range: " + number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
