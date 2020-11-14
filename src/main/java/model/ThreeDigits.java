package model;

import java.util.Arrays;

public class ThreeDigits {
    public static final int COUNT_OF_DIGITS = 3;

    private final int[] digits;

    public ThreeDigits(char digit1, char digit2, char digit3) {
        this.digits = new int[COUNT_OF_DIGITS];
        this.digits[0] = Character.getNumericValue(digit1);
        this.digits[1] = Character.getNumericValue(digit2);
        this.digits[2] = Character.getNumericValue(digit3);
    }

    public boolean contains(int expected) {
        boolean isContained = false;

        for (int index = 0; !isContained && index < digits.length; index++) {
            int digit = digits[index];
            isContained = (digit == expected);
        }

        return isContained;
    }

    public int getDigitAt(int index) {
        return digits[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(digits);
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
        return Arrays.equals(digits, that.digits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digits);
    }
}
