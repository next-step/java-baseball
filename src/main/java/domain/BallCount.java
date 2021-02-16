package domain;

import java.util.Objects;

public class BallCount {

    private final int balls;
    private final int strikes;

    public BallCount(final int balls, final int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BallCount ballCount = (BallCount) o;
        return balls == ballCount.balls && strikes == ballCount.strikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, strikes);
    }
}
