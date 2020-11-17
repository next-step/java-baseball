package me.kingcjy.baseball.ball;

import java.util.Objects;

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
            throw new IllegalArgumentException("value는 " + MIN + "이상 " + MAX + "이하만 허용합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public Score getScore(BallNumber other) {
        if (this.equals(other)) {
            return Score.STRIKE;
        }

        if (this.value == other.value) {
            return Score.BALL;
        }

        return Score.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return value == that.value &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, position);
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "value=" + value +
                ", position=" + position +
                '}';
    }
}
