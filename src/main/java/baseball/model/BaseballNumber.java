package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import baseball.util.random.RandomNumberGenerator;
import lombok.Getter;

import static baseball.constants.BaseballConstant.*;

@Getter
public class BaseballNumber {
    private final int[] numbers;
    private final int size;
    private final int radix;

    private BaseballNumber(int size, int radix) {
        if (!checkSizeAndRadixValid(size, radix)) {
            throw new BaseballNumberFormatException(size, radix);
        }

        this.size = size;
        this.radix = radix;
        this.numbers = new int[this.size];
    }

    public BaseballNumber(String input) {
        this(input, DEFAULT_NUMBERS_SIZE, DEFAULT_NUMBER_RADIX);
    }

    public BaseballNumber(String input, int size, int radix) {
        this(size, radix);

        if (!checkStringInputValid(input, size, radix)) {
            throw new BaseballNumberFormatException(input);
        }

        this.saveFromInputString(input);

        if (!this.checkValid()) {
            throw new BaseballNumberFormatException(input);
        }
    }

    private void saveFromInputString(String input) {
        for (int i = 0; i < this.size; i++) {
            char c = input.charAt(i);
            numbers[i] = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
        }
    }

    public boolean checkValid() {
        return checkRadixValid() && checkSizeValid() && checkNumberValid();
    }

    private boolean checkSizeValid() {
        return this.size >= MIN_SIZE && this.size <= MAX_SIZE && this.size < this.radix;
    }

    private boolean checkRadixValid() {
        return this.radix >= MIN_RADIX && this.radix <= MAX_RADIX && this.radix > this.size;
    }

    private boolean checkNumberValid() {
        return checkNumberValid(0, this.size);
    }

    private boolean checkNumberValid(int startIndex, int endIndex) {
        boolean[] isChecked = new boolean[this.radix];
        for (int i = startIndex; i < endIndex; i++) {
            if (numbers[i] <= 0 || numbers[i] >= this.radix || isChecked[numbers[i]]) {
                return false;
            }

            isChecked[numbers[i]] = true;
        }

        return true;
    }

    public static boolean checkSizeAndRadixValid(int size, int radix) {
        return size < radix && size >= MIN_SIZE && radix <= MAX_RADIX;
    }

    public static boolean checkStringInputValid(String input, int size, int radix) {
        if (input == null || input.length() != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!checkCharacterValid(input.charAt(i), radix)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCharacterValid(char c, int radix) {
        int number = convertToInteger(c, radix);
        return Character.isDigit(c) || Character.isAlphabetic(c) && (number > 0 && number < radix);
    }

    private static int convertToInteger(char c, int radix) {
        return Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(Integer.toString(i, this.radix).toUpperCase());
        }

        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
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
            isChecked[0] = true;
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

        public Builder addRandomNumber() {
            this.checkNullNumberThenInit();

            if (this.isReadyForBuild()) {
                return this;
            }

            do {
                this.number.numbers[this.index] = (this.rng.generateRandomNumber(this.number.radix) % (this.number.radix - 1)) + 1;
            } while(this.isChecked[this.number.numbers[this.index]]);

            this.isChecked[this.number.numbers[this.index++]] = true;
            return this;
        }

        public Builder addRandomNumber(int count) {
            this.checkNullNumberThenInit();

            for (int i = 0; i < count && !this.isReadyForBuild(); i++) {
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

            if (!this.isReadyForBuild()) {
                this.addAll();
            }

            return this.number;
        }

        private void checkNullNumberThenInit() {
            if (this.number == null) {
                this.number = new BaseballNumber(this.size, this.radix);
            }
        }

        private boolean isReadyForBuild() {
            return this.number != null && this.index >= this.number.size;
        }
    }
}
