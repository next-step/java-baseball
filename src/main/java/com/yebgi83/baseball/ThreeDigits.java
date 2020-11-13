package com.yebgi83.baseball;

import java.util.Arrays;

public class ThreeDigits {
    public static ThreeDigits createFromString(String value) {
        char digit1 = value.charAt(0);
        char digit2 = value.charAt(1);
        char digit3 = value.charAt(2);
        return new ThreeDigits(digit1, digit2, digit3);
    }

    private final int[] numbers;

    public ThreeDigits(char digit1, char digit2, char digit3) {
        this.numbers = new int[3];
        this.numbers[0] = Character.getNumericValue(digit1);
        this.numbers[1] = Character.getNumericValue(digit2);
        this.numbers[2] = Character.getNumericValue(digit3);
    }

    public int getNumberAt(int index) {
        return numbers[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ThreeDigits that = (ThreeDigits) o;
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
