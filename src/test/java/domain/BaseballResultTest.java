package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballResultTest {

    BaseballResult baseballResult = new BaseballResult(Ball.of(2), Strike.of(1));

    @Test
    @DisplayName("볼 결과가 2점인지 확인한다.")
    public void resultBall() {
        assertThat(baseballResult.getBall().toString()).isEqualTo("2");
    }

    @Test
    @DisplayName("스트라이크 결과가 3점인지 확인한다.")
    public void resultStrike() {
        assertThat(baseballResult.getStrike().toString()).isEqualTo("1");
    }
}