package game.baseball.domain;

public class Ball {
    private int value;
    private int position;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }
}
