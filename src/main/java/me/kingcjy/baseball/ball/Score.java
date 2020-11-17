package me.kingcjy.baseball.ball;

/**
 * @author KingCjy
 */
public enum Score {
    STRIKE("스트라이크", 3), BALL("볼", 2), NOTHING("낫싱", 1);

    private String displayName;
    private int value;

    Score(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }

}
