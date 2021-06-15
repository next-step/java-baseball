package domain;

import domain.exception.BallPositionNotValidRangeException;

public class BallPosition {
    public static final int MIN_BALL_POSITION = 1;
    public static final int MAX_BALL_POSITION = 3;

    private int position;

    private BallPosition(int position) {
        numberRangeCheck(position);
        this.position = position;
    }

    public static BallPosition valueOf(int position) {
        return new BallPosition(position);
    }

    private void numberRangeCheck(int number) {
        if (number < MIN_BALL_POSITION || number > MAX_BALL_POSITION) {
            throw new BallPositionNotValidRangeException();
        }
    }

    public int position() {
        return this.position;
    }
}
