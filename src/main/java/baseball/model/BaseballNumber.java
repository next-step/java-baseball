package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import lombok.Getter;

@Getter
public class BaseballNumber {
    public static final int DEFAULT_NUMBERS_SIZE = 3;
    public static final int DEFAULT_NUMBER_RADIX = 10;

    private final int[] numbers;
    private final int size;
    private final int radix;

    public static Builder builder() {
        return new Builder();
    }

    private BaseballNumber() {
        this(DEFAULT_NUMBERS_SIZE, DEFAULT_NUMBER_RADIX);
    }

    private BaseballNumber(int size, int radix) {
        if (size <= 0) {
            size = DEFAULT_NUMBERS_SIZE;
        }

        if (radix <= 0) {
            radix = DEFAULT_NUMBER_RADIX;
        }

        this.size = size;
        this.radix = radix;
        this.numbers = new int[this.size];
    }

    public BaseballNumber(String input) {
        this(Integer.parseInt(input, DEFAULT_NUMBER_RADIX));
    }

    public BaseballNumber(String input, int size, int radix) {
        this(Integer.parseInt(input, radix), size, radix);
    }

    public BaseballNumber(int number) {
        this(number, DEFAULT_NUMBERS_SIZE, DEFAULT_NUMBER_RADIX);
    }

    public BaseballNumber(int number, int size, int radix) {
        this(size, radix);

        int numberTemp = number;

        boolean[] isChecked = new boolean[this.radix];
        for (int i = this.size - 1; i > -1; i--) {
            numbers[i] = numberTemp % this.radix;
            numberTemp /= this.radix;
        }

        if (!checkValid()) {
            throw new BaseballNumberFormatException(number);
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

        private Builder() {
            this.index = 0;
            this.size = 0;
            this.radix = 0;
        }

        public Builder radix(int radix) {
            this.radix = radix;

            return this;
        }

        public Builder size(int size) {
            this.size = size;

            return this;
        }

        public Builder addRandomNumber() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }

            do {
                this.number.numbers[index] = (int)(Math.random() * (this.number.radix - 1)) + 1;
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
            return this.addRandomNumber(this.number.size - this.index);
        }

        public BaseballNumber build() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }

            if (this.index < this.number.size) {
                this.addAll();
            }

            return this.number;
        }
    }
}
