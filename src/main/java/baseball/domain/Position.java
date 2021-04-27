package baseball.domain;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 0;

    public static final Position NOT_FOUND = new Position();

    private Integer position = Integer.MIN_VALUE;

    private Position() {
    }

    public Position(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("음수의 위치는 존재하지 않습니다.");
        }

        this.position = position;
    }



    public Pitching compare(Position destBallPosition) {
        if (this.equals(destBallPosition)) {
            return Pitching.STRIKE;
        } else if (destBallPosition.equals(Position.NOT_FOUND)) {
            return Pitching.MISSING;
        }

        return Pitching.BALL;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        Position position1 = (Position) target;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
