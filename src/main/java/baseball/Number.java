package baseball;

import java.util.Random;

public class Number {
    private static final int DIGIT_LOW_BOUND = 1;
    private static final int DIGIT_RIGHT_BOUND = 9;
    private static final int DIGIT_LENGTH = 3;
    private final int[] digits;

    public static class Builder {
        public Number Random() throws Exception {
            int[] digits = new Random().ints(
                DIGIT_LOW_BOUND, DIGIT_RIGHT_BOUND
            ).distinct().limit(DIGIT_LENGTH).toArray();

            verifyDigitsLength(digits);
            verifyDigitsValue(digits);

            return new Number(digits);
        }

        private void verifyDigitsLength(int[] digits) throws Exception {
            if (digits.length != DIGIT_LENGTH) {
                // TODO : define exception about verify digit length
                throw new Exception("Number's length doesn't matched with " + DIGIT_LENGTH);
            }
        }

        private void verifyDigitsValue(int[] digits) throws Exception {
            // boolean array of JAVA initalized default value is false
            boolean[] flag = new boolean[DIGIT_RIGHT_BOUND + 1];
            for (int digit : digits) {
                if (digit < DIGIT_LOW_BOUND) {
                    throw new Exception("Number's digit value is lower than " + DIGIT_LOW_BOUND);
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

    public Number(int[] digits) {
        this.digits = digits;
    }
}
