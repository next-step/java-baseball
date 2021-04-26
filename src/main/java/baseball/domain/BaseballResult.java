package baseball.domain;

import java.util.Objects;

import static baseball.domain.core.BaseballNos.MAX_BASEBALL_LIST_SIZE;

public final class BaseballResult {
    private int strike;
    private int ball;

    public BaseballResult() {
        this(0,0);
    }

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isPerfect(){
        return MAX_BASEBALL_LIST_SIZE == strike;
    }

    public boolean isNoting(){
        return (0 == strike) && (0 == ball);
    }

    public int incrementStrike(){
        return ++strike;
    }

    public int incrementBall(){
        return ++ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballResult that = (BaseballResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    @Override
    public String toString() {
        return String.format("%d 스트라이크, %d 볼", strike, ball);
    }
}
