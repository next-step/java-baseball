package baseball.util.random;

import baseball.model.BaseballNumber;

public class RandomBaseballNumberGenerator {
    RandomNumberGenerator rng;

    public RandomBaseballNumberGenerator() {
        this.rng = radix -> (int)(Math.random() * (radix - 1) + 1);
    }
    public RandomBaseballNumberGenerator(RandomNumberGenerator rng) {
        this.rng = rng;
    }

    int[] generateRandomBaseballNumberArray(int size, int radix) {
        if (radix <= 1 || radix > BaseballNumber.MAX_RADIX) {
            radix = BaseballNumber.DEFAULT_NUMBER_RADIX;
        }

        if (size <= 0 || size >= radix) {
            size = radix - 1;
        }

        boolean[] isChecked = new boolean[radix];
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            int number = this.generateRandomBaseballNumber(radix);

            if (isChecked[number]) {
                i--;
                continue;
            }

            isChecked[number] = true;
            numbers[i] = number;
        }

        return numbers;
    }

    public String generateRandomBaseballNumberString(int size, int radix) {
        int[] numbers = this.generateRandomBaseballNumberArray(size, radix);

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(Integer.toString(i, radix).toUpperCase());
        }

        return sb.toString();
    }

    public BaseballNumber generateRandomBaseballNumber(int size, int radix) {
        return new BaseballNumber(this.generateRandomBaseballNumberString(size, radix), size, radix);
    }

    private int generateRandomBaseballNumber(int radix) {
        int result = rng.generateRandomNumber(radix) % (radix - 1) + 1;
        if (result <= 0 || result >= radix) {
            throw new RuntimeException("....");
        }
        return result;
    }
}
