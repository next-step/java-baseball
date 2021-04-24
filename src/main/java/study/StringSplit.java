package study;

import utils.StringUtils;

public class StringSplit {
    private final String input;

    public StringSplit(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
    }

    public int[] splitWith(String delimiter) {
        if (StringUtils.isBlank(delimiter)) {
            throw new IllegalArgumentException();
        }
        final String trimText = input.trim();
        final String[] textNumbers = trimText.split(delimiter);
        return changeToNumbers(textNumbers);
    }

    private int[] changeToNumbers(String[] textNumbers) {
        final int[] numbers = new int[textNumbers.length];

        for (int i = 0; i < textNumbers.length; i++) {
            numbers[i] = changeToNumber(textNumbers[i]);
        }
        return numbers;
    }

    private int changeToNumber(String stringNumber) {
        try {
            return (Integer.parseInt(stringNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
