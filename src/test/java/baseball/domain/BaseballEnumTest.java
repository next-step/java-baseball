package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BaseballEnumTest {

    @Test
    void enumMessageTest() {
        assertThat(BaseballEnum.STRIKE.getMessage()).isEqualTo("스트라이크");
        assertThat(BaseballEnum.BALL.getMessage()).isEqualTo("볼");
    }
}
