package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class HitterTest {
    public Hitter hitter = new Hitter();

    @BeforeEach
    @DisplayName("생성된 3자리 난수가 null이 아닌지 테스트")
    void generated_random_ball_list_is_not_null() {
        assertThat(hitter.getBallList()).isNotNull();
    }

    @Test
    @DisplayName("생성된 3자리 난수의 크기가 3인지 테스트")
    void generated_random_ball_list_size_test() {
        assertThat(hitter.getBallList().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 3자리 난수가 중복이 아닌지 테스트")
    void generated_random_ball_list_ball_is_independent() {
        for (int ball : hitter.getBallList()) {
            assertThat(Collections.frequency(hitter.getBallList(), ball)).isOne();
        }
    }

    @Test
    @DisplayName("생성된 3자리 난수가 1부터 9까지 값인지 테스트")
    void generated_random_ball_list_1to9_test() {
        for (int ball : hitter.getBallList()) {
            assertThat(ball).isGreaterThan(0);
            assertThat(ball).isLessThan(10);
        }
    }
}
