package BaseballGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InningTest {

    @DisplayName("이닝 결과 가져오기 테스트")
    @Test
    void InningGetInfoTest() {
        // given
        Inning inning = new Inning(123, 1, 2);

        // when

        // then
        assertThat(inning.getTryNumber()).isEqualTo(123);
        assertThat(inning.getStrike()).isEqualTo(1);
        assertThat(inning.getBall()).isEqualTo(2);
    }
}
