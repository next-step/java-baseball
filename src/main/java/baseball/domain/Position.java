package baseball.domain;

import java.util.Objects;

public class Position {
    public static final Position NOT_FOUND = new Position();

    private int position = Integer.MIN_VALUE;

    private Position() {}

    public Position(int position) {
        if(position < 0) {
            throw new IllegalArgumentException("음수의 위치는 존재하지 않습니다.");
        }

        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
