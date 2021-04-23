import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class GameMachineTest {

    @Test
    @DisplayName("GameMachine 생성")
    void createGameMachineTest() {
        GameMachine gameMachine = GameMachine.of();
        assertThat(gameMachine).isNotNull();
        assertThat(gameMachine.getRandomSetSize()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값 설정")
    void setRandomValueTest() {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init();
        assertThat(gameMachine.getRandomSetSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("고정 랜덤값 설정")
    void setFixedRandomValueTest() {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init(new int[]{1, 2, 3});
        assertThat(gameMachine.getRandomSetSize()).isEqualTo(3);

        assertThatIllegalStateException().isThrownBy(() -> GameMachine.of().init(new int[]{1, 1, 3}))
                .withMessage("중복된 값이 존재합니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().init(new int[]{1, 2, 11}))
                .withMessage("랜덤 값은 1 ~ 9까지 수여야 합니다.");
    }
}