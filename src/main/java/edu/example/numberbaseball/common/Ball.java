package edu.example.numberbaseball.common;

/**
 * 야구게임에서 사용할 `Ball`
 */
public class Ball {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final int number;

    public Ball(char value) {
        this(Character.getNumericValue(value));
    }

    public Ball(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("공의 숫자가 " + number + "로 범위 [" + START_NUMBER + "," + END_NUMBER + "]를 넘었습니다.");
        }
        this.number = number;
    }

    public static int getStartNumber() {
        return START_NUMBER;
    }

    public static int getEndNumber() {
        return END_NUMBER;
    }

    private boolean isValid(int number) {
        return number >= START_NUMBER && number <= END_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
