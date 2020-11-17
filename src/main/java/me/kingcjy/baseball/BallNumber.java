package me.kingcjy.baseball;

/**
 * @author KingCjy
 */
public class BallNumber {
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int value;
    private final int position;

    public BallNumber(int value, int position) {
        this.value = value;
        this.position = position;

        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("");
        }
    }

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }
}
