import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class PlayerTest {

    @DisplayName("Player 초기 상태는 READY")
    @Test
    void isReadyTest() {
        // given
        Player player = new Player();

        // then
        assertThat(player.isReady()).isTrue();
    }

    @DisplayName("play 메소드를 실행하면 playing 상태로 변경")
    @Test
    void playingTest() {
        // given
        Player player = new Player();
        assertThat(player.playing()).isFalse();

        // when
        player.play();

        // then
        assertThat(player.playing()).isTrue();
    }

    @DisplayName("성공한 Result 를 넣어주면 ANSWER_CORRECTLY 상태로 변경")
    @Test
    void changeStatusIfSuccessTest() {
        // given
        Player player = new Player();
        Result result = new Result();
        assertThat(player.notSelected()).isFalse();

        player.changeStatusIfSuccess(result);
        assertThat(player.notSelected()).isFalse();

        // when
        result.doSuccess();
        player.changeStatusIfSuccess(result);

        // then
        assertThat(player.notSelected()).isTrue();
    }

    @DisplayName("Restart 선택하면 READY 상태로")
    @Test
    void restartTest() {
        // given
        Player player = new Player();
        String RESTART = "1";

        // when
        player.restartOrExit(RESTART);

        // then
        assertThat(player.isReady()).isTrue();
    }

    @DisplayName("Exit 선택하면 EXIT 상태로")
    @Test
    void exitTest() {
        // given
        Player player = new Player();
        String EXIT = "2";

        // when
        player.restartOrExit(EXIT);

        // then
        assertThat(player.isReady()).isFalse();
        assertThat(player.playing()).isFalse();
        assertThat(player.notSelected()).isFalse();
    }
}