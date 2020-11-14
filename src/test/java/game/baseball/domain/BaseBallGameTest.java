package game.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallGameTest {

    @Test
    @DisplayName("정상 실행")
    void testBaseBallGame() {
        // given
        String number = "123";
        BaseBallGame game = new BaseBallGame.Builder().build();

        // when
        game.start(new BaseBallNumbers(number), () -> number);

        // then
        assertThat(game.isOver()).isTrue();
    }

    @Test
    @DisplayName("종료된 게임 재실행 시 예외")
    void testAlreadyEndedGame() {
        // given
        String number = "123";
        BaseBallGame game = new BaseBallGame.Builder().build();

        // when
        game.start(new BaseBallNumbers(number), () -> number);

        // then
        assertThatThrownBy(() -> game.start(() -> "144")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("3번째 만에 정답 발견 후 종료")
    void testTryThreeTime() {
        // given
        BaseBallNumbers numbers = new BaseBallNumbers("123");
        BaseBallGame game = new BaseBallGame.Builder().build();

        // when
        game.doStart(numbers, () -> "312");
        game.doStart(numbers, () -> "367");
        game.doStart(numbers, () -> "123");

        // then
        assertThat(game.isOver()).isTrue();
    }

    @Test
    @DisplayName("정답을 맞추지 못한 경우")
    void testNotFoundNumberAnswer() {
        // given
        BaseBallNumbers numbers = new BaseBallNumbers("123");
        BaseBallGame game = new BaseBallGame.Builder().build();

        // when
        game.doStart(numbers, () -> "549");

        // then
        assertThat(game.isOver()).isFalse();
    }

    @Test
    @DisplayName("종료된 게임 재실행 명령 후 재실행")
    void testGameRestart() {
        // 첫번째 게임
        String number = "123";
        BaseBallGame game = new BaseBallGame.Builder().build();

        game.start(new BaseBallNumbers(number), () -> number);
        // 종료 확인
        assertThat(game.isOver()).isTrue();

        // 두번째 게임을 쥐한 종료 취소
        game.undoOver();

        // 종료 확인
        assertThat(game.isOver()).isFalse();

        // 다시 시작
        game.start(new BaseBallNumbers(number), () -> number);

        // 두번째 종료 확인
        assertThat(game.isOver()).isTrue();
    }
}
