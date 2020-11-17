package me.kingcjy.baseball;

/**
 * @author KingCjy
 */
public enum Score {
    STRIKE(3), BALL(2), NOTHING(1);

    private int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
