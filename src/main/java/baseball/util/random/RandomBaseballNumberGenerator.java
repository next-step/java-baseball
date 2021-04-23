package baseball.util.random;

import baseball.model.BaseballNumber;

public class RandomBaseballNumberGenerator {
    private RandomNumberGenerator rng;

    public RandomBaseballNumberGenerator() {
        this.rng = RandomNumberGenerator.getDefault();
    }
    public RandomBaseballNumberGenerator(RandomNumberGenerator rng) {
        this.rng = rng;
    }

    protected int[] generateRandomBaseballNumberArray(int size, int radix) {
        if (radix < BaseballNumber.MIN_RADIX || radix > BaseballNumber.MAX_RADIX) {
            radix = BaseballNumber.DEFAULT_NUMBER_RADIX;
        }

        if (size < BaseballNumber.MIN_SIZE || size >= radix) {
            size = radix - 1;
        }

        boolean[] isChecked = new boolean[radix];
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            int number = this.generateRandomBaseballNumber(radix);

            if (number == 0 || isChecked[number]) {
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
        return (rng.generateRandomNumber(radix) % (radix - 1))+ 1;
    }
}
