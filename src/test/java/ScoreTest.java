import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 결과 클래스 테스트")
class ScoreTest {
    Score score = new Score();

    @Test
    @DisplayName("3진 아웃 테스트")
    void isStrikeoutTest() {
        score.addStrike();
        score.addStrike();
        score.addStrike();

        assertThat(score.isStrikeout()).isTrue();
    }

    @Test
    @DisplayName("결과가 텍스트로 잘 나오는지 확인하는 테스트")
    void calculateScoreTest() {
        score.addStrike();
        score.addStrike();
        score.addBall();
        assertThat(score.calculateScore()).isEqualTo("2 스트라이크 1 볼");
    }

    @Test
    @DisplayName("결과가 포볼인 테스트")
    void fourBallTest() {
        assertThat(score.calculateScore()).isEqualTo("포볼");
    }
}