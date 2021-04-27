package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallGeneratorTest {

    @DisplayName("공을 랜덤하게 중복없이 3개 추출한다.")
    @Test
    public void testBallNumberCreate() {
        assertThat(BallGenerator.getBallNumbers().getSize()).isSameAs(3);
    }

    @DisplayName("볼 숫자 범위를 생성한다.")
    @Test
    void canCreateBallNumbers() {
        assertThat(BallGenerator.generateNumbers().size()).isSameAs(9);
    }
}
