package baseball.domain.score;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalTest {

    @Test
    void printStrikeAndBall() {
        Normal normal = new Normal(2, 1);
        assertThat(normal.getResult()).isEqualTo("2스트라이크 1볼");
    }

    @Test
    void printStrike() {
        Normal normal = new Normal(2, 0);
        assertThat(normal.getResult()).isEqualTo("2스트라이크");
    }

    @Test
    void printBall() {
        Normal normal = new Normal(0, 2);
        assertThat(normal.getResult()).isEqualTo("2볼");
    }
}
