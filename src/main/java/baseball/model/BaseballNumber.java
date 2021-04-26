package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import baseball.util.random.RandomNumberGenerator;
import lombok.Getter;

// TODO: Random Number Generator (Strategy Pattern)
@Getter
public class BaseballNumber {
    public static final int DEFAULT_NUMBERS_SIZE = 3;
    public static final int DEFAULT_NUMBER_RADIX = 10;
    public static final int MAX_RADIX = 'z' - 'a' + 10;
    public static final int MIN_RADIX = 2;
    public static final int MAX_SIZE = MAX_RADIX - 1;
    public static final int MIN_SIZE = MIN_RADIX - 1;

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
            char c = input.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
                throw new BaseballNumberFormatException(input);
            }

            numbers[i] = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
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
            if (numbers[i] < 0 || numbers[i] >= this.radix || isChecked[numbers[i]] || numbers[i] == 0) {
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
        private RandomNumberGenerator rng;

        private Builder() {
            this.index = 0;
            this.size = 0;
            this.radix = 0;
            isChecked = new boolean[MAX_RADIX];
            this.rng = RandomNumberGenerator.getDefault();
        }

        public Builder radix(int radix) {
            this.radix = radix;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder random(RandomNumberGenerator rng) {
            this.rng = rng;
            return this;
        }

        private Builder addRandomNumber() {
            this.checkNullNumberThenInit();

            if (this.index >= this.number.size) {
                return this;
            }

            do {
                this.number.numbers[this.index] = (this.rng.generateRandomNumber(this.number.radix) % (this.number.radix - 1)) + 1;
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
            this.checkNullNumberThenInit();

            return this.addRandomNumber(this.number.size - this.index);
        }

        public BaseballNumber build() {
            this.checkNullNumberThenInit();

            this.isChecked = new boolean[this.number.radix];

            if (this.index < this.number.size) {
                this.addAll();
            }

            return this.number;
        }

        private void checkNullNumberThenInit() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }
        }
    }
}
