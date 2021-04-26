package domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStatusTest {

    @Test
    @DisplayName("게임상태가 RESTART인지 true를 리턴한다.")
    public void restart() {
        GameStatus restart = GameStatus.of("1");
        assertThat(restart.isRestart()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임상태가 STOP인지 false를 리턴한다.")
    public void stop() {
        GameStatus restart = GameStatus.of("2");
        assertThat(restart.isRestart()).isEqualTo(false);
    }

    @Test
    @DisplayName("시작,종료 번호가 아니면 IllegalArgumentException를 리턴한다.")
    public void abnormalInputStringNum() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameStatus.of("3");
        });

    }

    @Test
    @DisplayName("문자를 입력하면 IllegalArgumentException를 리턴한다.")
    public void abnormalInputChar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameStatus.of("g");
        });
    }

}