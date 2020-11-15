package domain;

import exception.DuplicateNumberOfDigitException;
import exception.InvalidNumberOfDigitRange;
import exception.NumberNotThreeDigitsException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static domain.BaseballCodeDefinition.MAX_DIGIT;
import static domain.BaseballCodeDefinition.MIN_DIGIT;
import static domain.BaseballCodeDefinition.NUMBER_OF_DIGIT;

public class Number {
    private List<Integer> digits;

    public Number() {
        this.digits = init();
    }

    public Number(int userNumber) {
        this.digits = convertUserNumberToDigits(userNumber);
        validate();
    }

    private List<Integer> init() {
        List<String> digitPool = createDigitPool();
        return createDigits(digitPool);
    }

    private List<String> createDigitPool() {
        List<String> digitPool = new ArrayList<>();
        for (int i = MIN_DIGIT; i <= MAX_DIGIT; i++) {
            digitPool.add(String.valueOf(i));
        }
        return digitPool;
    }

    private List<Integer> createDigits(List<String> digitPool) {
        List<Integer> digits = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            int index = random.nextInt(digitPool.size());
            digits.add(Integer.parseInt(digitPool.get(index)));
            digitPool.remove(index);
        }

        return digits;
    }

    private List<Integer> convertUserNumberToDigits(int userNumber) {
        List<Integer> digits = new ArrayList<>();
        String numberString = String.valueOf(userNumber);

        for (int i = 0; i < numberString.length(); i++) {
            digits.add(Integer.parseInt(String.valueOf(numberString.charAt(i))));
        }
        return digits;
    }

    private void validate() {
        if (!isNumberOfThreeDigits()) {
            throw new NumberNotThreeDigitsException();
        }

        if (!isNumberOfDigitBetweenOneToNine()) {
            throw new InvalidNumberOfDigitRange();
        }

        if (!isNumberOfDigitDifferentEachOther()) {
            throw new DuplicateNumberOfDigitException();
        }
    }

    public boolean isNumberOfThreeDigits() {
        return digits.size() == NUMBER_OF_DIGIT;
    }

    public boolean isNumberOfDigitBetweenOneToNine() {
        boolean isValid = true;

        for (Integer digit : digits) {
            isValid = isValid && MIN_DIGIT <= digit && digit <= MAX_DIGIT;
        }

        return isValid;
    }

    public boolean isNumberOfDigitDifferentEachOther() {
        return this.digits.size() == new HashSet<>(this.digits).size();
    }
}
