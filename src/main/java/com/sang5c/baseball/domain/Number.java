package com.sang5c.baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {

    private static final String ERROR_EMPTY_STRING = "number null or empty";
    private static final String ERROR_OUT_OF_RANGE = "out of range: ";

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
        checkNullOrEmpty(number);
        return of(Integer.parseInt(number));
    }

    private static void checkNullOrEmpty(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_STRING);
        }
    }

    public static Number of(int number) {
        validate(number);
        return cache.get(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE + number);
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

}
