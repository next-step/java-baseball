package model;

import java.util.Arrays;

public class ThreeDigits {
    public static ThreeDigits createFrom(String value) {
        char digit1 = value.charAt(0);
        char digit2 = value.charAt(1);
        char digit3 = value.charAt(2);
        return new ThreeDigits(digit1, digit2, digit3);
    }

    private final int[] digits;

    public ThreeDigits(char digit1, char digit2, char digit3) {
        this.digits = new int[3];
        this.digits[0] = Character.getNumericValue(digit1);
        this.digits[1] = Character.getNumericValue(digit2);
        this.digits[2] = Character.getNumericValue(digit3);
    }

    public boolean contains(int expected) {
        for (int digit : digits) {
            if (digit == expected) {
                return true;
            }
        }

        return false;
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
