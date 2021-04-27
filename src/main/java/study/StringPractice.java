package study;

import utils.StringUtils;

public class StringPractice {
    public static final String OPEN_BRACKET = "(";
    public static final String CLOSE_BRACKET = ")";
    public static final String NOT_NUMBER = "숫자가 아닙니다.";
    public static final String STRING_INDEX_NOT_FOUND = "문자내 인덱스 위치를 찾을 수 없습니다.";

    private final String input;

    public StringPractice(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
    }

    public char findIndex(int index) {
        try {
            return input.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException(STRING_INDEX_NOT_FOUND);
        }
    }

    public int[] splitWith(String delimiter) {
        if (StringUtils.isBlank(delimiter)) {
            throw new IllegalArgumentException();
        }
        final String trimText = trimText(input);
        final String[] textNumbers = trimText.split(delimiter);
        return changeToNumbers(textNumbers);
    }

    private String trimText(String text) {
        if (text.contains(OPEN_BRACKET) && text.contains(CLOSE_BRACKET)) {
            int startBracketIndex = text.indexOf(OPEN_BRACKET);
            int closeBracketIndex = text.indexOf(CLOSE_BRACKET);
            return text.substring(startBracketIndex + 1,  closeBracketIndex).trim();
        }
        return text.trim();
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
            throw new NumberFormatException(NOT_NUMBER);
        }
    }
}
