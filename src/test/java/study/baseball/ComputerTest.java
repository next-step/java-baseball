package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {

    @Test
    @DisplayName("숫자 생성이 정상적인지 테스트")
    void 숫자_정상_생성_테스트() {
        assertThat(Computer.generateBaseballNumber()).isGreaterThan(122)
                .isLessThan(988)
                .isNotZero()
                .isPositive();

    }

}
