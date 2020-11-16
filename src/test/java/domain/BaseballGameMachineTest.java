package domain;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameMachineTest {
    @Test
    @DisplayName("게임 지속 여부가 참이고, `정답`을 가지고 있는 숫자 야구 게임을 시작한다.")
    void gameStartTest() {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();

        assertThat(baseballGameMachine).extracting("baseballGame")
                .isNotNull();
        assertThat(baseballGameMachine).extracting("baseballGame")
                .extracting("answer")
                .isNotNull();
        assertThat(baseballGameMachine.isBaseballGameContinue()).isTrue();
    }
}