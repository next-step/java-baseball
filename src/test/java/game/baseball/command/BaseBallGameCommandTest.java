package game.baseball.command;

import game.baseball.domain.BaseBallGame;
import game.baseball.domain.BaseBallNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameCommandTest {

    @Test
    @DisplayName("숫자 전달 시 명령어 확인")
    void testGameCommandReturn() {
        assertThat(BaseBallGameCommand.valueOf(() -> 1)).isEqualTo(BaseBallGameCommand.RESTART);
        assertThat(BaseBallGameCommand.valueOf(() -> 2)).isEqualTo(BaseBallGameCommand.QUIT);
    }

    @Test
    @DisplayName("게임 재시작")
    void testGameRestart() {

        // 첫 번째 게임
        String number = "123";
        BaseBallGame game = new BaseBallGame.Builder().build();

        game.start(new BaseBallNumbers(number), () -> number);

        assertThat(game.isOver()).isTrue();

        // 명령어를 통한 재시작
        BaseBallGameCommand.valueOf(() -> 1).run(game);

        // 두 번째 게임
        game.start(new BaseBallNumbers(number), () -> number);

        assertThat(game.isOver()).isTrue();
    }

    @Test
    @DisplayName("게임 종료")
    void testGameOver() {

        // 첫 번째 게임
        String number = "123";
        BaseBallGame game = new BaseBallGame.Builder().build();

        game.start(new BaseBallNumbers(number), () -> number);

        assertThat(game.isOver()).isTrue();

        // 명령어를 수행 시 동일한 결과
        BaseBallGameCommand.valueOf(() -> 2).run(game);

        assertThat(game.isOver()).isTrue();
    }
}
