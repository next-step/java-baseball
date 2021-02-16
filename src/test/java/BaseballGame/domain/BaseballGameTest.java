package BaseballGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @DisplayName("정답 생성 테스트")
    @Test
    void createAnswerTest() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        int answer = baseballGame.createAnswer();
        boolean isOverHundred = answer > 100;
        boolean isUnderThousand = answer < 1000;

        // then
        assertThat(isOverHundred).isEqualTo(true);
        assertThat(isUnderThousand).isEqualTo(true);
    }

    @DisplayName("BaseballGame 한 이닝 플레이 테스트")
    @Test
    void playInningTest() {
        // given
        int tryNumber = 345;
        BaseballGame baseballGame = new BaseballGame();

        // when
        baseballGame.playInning(tryNumber);

        // then
        assertThat(baseballGame.getBaseballRecord().getChart()).hasSize(1);
    }
}
