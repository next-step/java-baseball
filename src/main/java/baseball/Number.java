package baseball;

import java.util.Arrays;
import java.util.Random;

public class Number {
    private static final int DIGIT_LEFT_BOUND = 1;
    private static final int DIGIT_RIGHT_BOUND = 9;
    private static final int DIGIT_LENGTH = 3;
    private final int[] digits;

    public static class Builder {
        public Number byRandom() throws Exception {
            int[] digits = new Random().ints(
                DIGIT_LEFT_BOUND, DIGIT_RIGHT_BOUND
            ).distinct().limit(DIGIT_LENGTH).toArray();

            return new Number(digits);
        }

        public Number byInt(int num) throws Exception {
            int[] digits = Arrays.stream(
                String.valueOf(num).split("")
            ).mapToInt(
                Integer::parseInt
            ).toArray();

            return new Number(digits);
        }
    }

    public Number(int[] digits) throws Exception {
        verifyDigits(digits);
        this.digits = digits;
    }

    public int[] getDigits() {
        return digits;
    }

    private void verifyDigits(int[] digits) throws Exception {
        if (digits.length != DIGIT_LENGTH) {
            // TODO : define exception about verify exceptions
            throw new Exception("Number's length doesn't matched with " + DIGIT_LENGTH);
        }

        // boolean array of JAVA initalized default value is false
        boolean[] flag = new boolean[DIGIT_RIGHT_BOUND + 1];
        for (int digit : digits) {
            if (digit < DIGIT_LEFT_BOUND) {
                throw new Exception("Number's digit value is lower than " + DIGIT_LEFT_BOUND);
            }

            if (digit > DIGIT_RIGHT_BOUND) {
                throw new Exception("Number's digit value is bigger than " + DIGIT_RIGHT_BOUND);
            }

            if (flag[digit] == true) {
                throw new Exception("Number's digit value is overlapped : " + digit);
            }
            flag[digit] = true;
        }
    }
}
