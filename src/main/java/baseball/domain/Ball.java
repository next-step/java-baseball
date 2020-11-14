package baseball.domain;

import java.util.Objects;

public class Ball {
    private int number;
    private int order;

    public Ball(int number, int order) {
        validate(number, order);
        this.number = number;
        this.order = order;
    }

    private void validate(int number, int order) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1-9 사이 값을 입력해주세요");
        }

        if (order < 0 || order > 2) {
            throw new IllegalArgumentException("순서값이 잘못됐습니다.");
        }
    }

    public Status compare(Ball ball) {
        if (this.number != ball.number) {
            return Status.find(-1);
        }

        return this.order == ball.order ? Status.find(1) : Status.find(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number &&
                order == ball.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, order);
    }
}
