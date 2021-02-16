package BaseballGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @DisplayName("정답 생성 테스")
    @Test
    void createAnswerTest() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        int answer = baseballGame.createAnswer();

        // then
        System.out.println(answer);;
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
