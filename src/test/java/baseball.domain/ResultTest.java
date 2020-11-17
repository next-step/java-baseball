package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    Result result = new Result(Ball.of(2), Strike.of(1));

    @Test
    public void countBall() {
        assertThat(result.getBall().toString()).isEqualTo("2");
    }

    @Test
    public void countStrike() {
        assertThat(result.getStrike().toString()).isEqualTo("1");
    }
}
