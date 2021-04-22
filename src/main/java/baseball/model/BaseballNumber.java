package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import lombok.Getter;

public class BaseballNumber {
    public static final int NUMBERS_SIZE = 3;
    public static final int NUMBER_RADIX = 10;

    @Getter
    private int[] numbers;

    public static Builder builder() {
        return new Builder();
    }

    private BaseballNumber() {
        numbers = new int[NUMBERS_SIZE];
    }

    public BaseballNumber(String input) {
        this(Integer.parseInt(input, NUMBER_RADIX));
    }

    public BaseballNumber(int number) {
        this();
        for (int i = NUMBERS_SIZE - 1; i > -1; i--) {
            numbers[i] = number % NUMBER_RADIX;
            number /= NUMBER_RADIX;
        }

        if (!checkValid()) {
            throw new BaseballNumberFormatException(this);
        }
    }

    private boolean checkValid() {
        return checkValid(0, NUMBERS_SIZE);
    }

    private boolean checkValid(int startIndex, int endIndex) {
        boolean[] isChecked = new boolean[NUMBER_RADIX];
        for (int i = startIndex; i < endIndex; i++) {
            if (isChecked[numbers[i]]) {
                return false;
            }

            isChecked[numbers[i]] = true;
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i);
        }

        return sb.toString();
    }

    public static class Builder {
        private BaseballNumber number;

        private int index;

        private Builder() {
            this.index = 0;
            this.number = new BaseballNumber();
        }

        public Builder addRandomNumber() {
            do {
                this.number.numbers[index] = (int)(Math.random() * (NUMBER_RADIX - 1)) + 1;
            } while(!number.checkValid(0, index + 1));

            this.index++;
            return this;
        }

        public Builder addRandomNumber(int count) {
            for (int i = 0; i < count; i++) {
                this.addRandomNumber();
            }

            return this;
        }

        private Builder addAll() {
            return this.addRandomNumber(NUMBERS_SIZE - this.index);
        }

        public BaseballNumber build() {
            if (this.index < NUMBERS_SIZE) {
                this.addAll();
            }

            return this.number;

        }
    }
}
