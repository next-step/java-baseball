package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import lombok.Getter;

// TODO: Random Number Generator (Strategy Pattern)
@Getter
public class BaseballNumber {
    public static final int DEFAULT_NUMBERS_SIZE = 3;
    public static final int DEFAULT_NUMBER_RADIX = 10;
    public static final int MAX_RADIX = 'z' - 'a' + 10;
    public static final int MIN_RADIX = 2;

    private final int[] numbers;
    private final int size;
    private final int radix;

    public static Builder builder() {
        return new Builder();
    }

    private BaseballNumber(int size, int radix) {
        if (size <= 0) {
            size = DEFAULT_NUMBERS_SIZE;
        }

        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            radix = DEFAULT_NUMBER_RADIX;
        }

        this.size = size >= radix ? radix - 1 : size;
        this.radix = radix;
        this.numbers = new int[this.size];
    }

    public BaseballNumber(String input) {
        this(input, DEFAULT_NUMBERS_SIZE, DEFAULT_NUMBER_RADIX);
    }

    public BaseballNumber(String input, int size, int radix) {
        this(size, radix);

        if (input == null || input.length() != this.size) {
            throw new BaseballNumberFormatException(input);
        }

        for (int i = 0; i < this.size; i++) {
            numbers[i] = Character.isDigit(input.charAt(i)) ? input.charAt(i) - '0' : Character.toUpperCase(input.charAt(i)) - 'A' + 10;
        }

        if (!checkValid()) {
            throw new BaseballNumberFormatException(input);
        }

    }

    private boolean checkValid() {
        return checkValid(0, this.size);
    }

    private boolean checkValid(int startIndex, int endIndex) {
        boolean[] isChecked = new boolean[this.radix];
        for (int i = startIndex; i < endIndex; i++) {
            if (isChecked[numbers[i]] || numbers[i] == 0) {
                return false;
            }

            isChecked[numbers[i]] = true;
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(Integer.toString(i, this.radix).toUpperCase());
        }

        return sb.toString();
    }

    public static class Builder {
        private BaseballNumber number;

        private int index;
        private int size;
        private int radix;
        private boolean[] isChecked;

        private Builder() {
            this.index = 0;
            this.size = 0;
            this.radix = 0;
            isChecked = new boolean[MAX_RADIX];
        }

        public Builder radix(int radix) {
            this.radix = radix;

            return this;
        }

        public Builder size(int size) {
            this.size = size;

            return this;
        }

        private Builder addRandomNumber() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }

            if (this.index >= this.number.size) {
                return this;
            }

            do {
                this.number.numbers[this.index] = (int) (Math.random() * (this.number.radix - 1)) + 1;
            } while(this.number.numbers[this.index] == 0
                    || this.isChecked[this.number.numbers[this.index]]);

            this.isChecked[this.number.numbers[this.index++]] = true;
            return this;
        }

        public Builder addRandomNumber(int count) {
            for (int i = 0; i < count; i++) {
                this.addRandomNumber();
            }

            return this;
        }

        public Builder addAll() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }

            return this.addRandomNumber(this.number.size - this.index);
        }

        public BaseballNumber build() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }

            this.isChecked = new boolean[this.number.radix];

            if (this.index < this.number.size) {
                this.addAll();
            }

            return this.number;
        }
    }
}
