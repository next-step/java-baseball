package baseball.game.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.game.domain.Balls;
import baseball.game.domain.generator.DirectBallsGenerator;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameResultTest {

    @Test
    @DisplayName("3 스트라이크 게임 결과 테스트")
    void result_3strike() {
        Balls gameBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));
        Balls inputBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));


        BaseBallGameResult result = new BaseBallGameResult();
        result.result(gameBalls, inputBalls);

        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isZero();
    }

    @Test
    @DisplayName("3 볼 게임 결과 테스트")
    void result_3ball() {
        Balls gameBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));
        Balls inputBalls = DirectBallsGenerator.generate(Arrays.asList(5, 1, 3));


        BaseBallGameResult result = new BaseBallGameResult();
        result.result(gameBalls, inputBalls);

        assertThat(result.getStrikeCount()).isZero();
        assertThat(result.getBallCount()).isEqualTo(3);
    }


    @Test
    @DisplayName("스트라이크 카운트 증가 테스트")
    void count_strike() {
        BaseBallGameResult result = new BaseBallGameResult();
        result.count(BallResultType.STRIKE);

        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isZero();
    }

    @Test
    @DisplayName("볼 카운트 증가 테스트")
    void count_ball() {
        BaseBallGameResult result = new BaseBallGameResult();
        result.count(BallResultType.BALL);

        assertThat(result.getStrikeCount()).isZero();
        assertThat(result.getBallCount()).isEqualTo(1);
    }
}