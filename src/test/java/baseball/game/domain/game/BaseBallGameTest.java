package baseball.game.domain.game;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.domain.Balls;
import baseball.game.domain.generator.DirectBallsGenerator;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    @DisplayName("게임 결과 3 스트라이크")
    void gameResult_3strike() {
        Balls gameBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));
        Balls inputBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));

        BaseBallGame baseBallGame = BaseBallGame.createGame(gameBalls);
        BaseBallGameResultType result = baseBallGame.getResult(inputBalls);

        assertThat(result).isEqualTo(BaseBallGameResultType.THREE_STRIKE);

    }

    @Test
    @DisplayName("게임 결과 1 스트라이크 1 볼")
    void gameResult_2strike_1ball() {
        Balls gameBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));
        Balls inputBalls = DirectBallsGenerator.generate(Arrays.asList(1, 4, 3));

        BaseBallGame baseBallGame = BaseBallGame.createGame(gameBalls);
        BaseBallGameResultType result = baseBallGame.getResult(inputBalls);

        assertThat(result).isEqualTo(BaseBallGameResultType.ONE_STRIKE_ONE_BALL);

    }

    @Test
    @DisplayName("게임 결과 낫싱")
    void gameResult_nothing() {
        Balls gameBalls = DirectBallsGenerator.generate(Arrays.asList(1, 3, 5));
        Balls inputBalls = DirectBallsGenerator.generate(Arrays.asList(2, 4, 6));

        BaseBallGame baseBallGame = BaseBallGame.createGame(gameBalls);
        BaseBallGameResultType result = baseBallGame.getResult(inputBalls);

        assertThat(result).isEqualTo(BaseBallGameResultType.NOTHING);

    }
}