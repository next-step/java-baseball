package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @DisplayName("BaseballGame 한 이닝 플레이 테스트")
    @Test
    void playInningTest() {
        // given
        int answer = 123;
        int tryNumber = 345;
        BaseballGame baseballGame = new BaseballGame(answer);

        // when
        baseballGame.playInning(tryNumber);

        // then
        assertThat(baseballGame.getBaseballRecord().getChart()).hasSize(1);
    }
}
