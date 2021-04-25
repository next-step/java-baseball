package game;

import game.GameMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임머신 테스트")
class GameMachineTest {

    @Test
    @DisplayName("game.GameMachine 생성")
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
                .withMessage("중복된 값이 존재합니다");
        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().init(new int[]{1, 2, 11}))
                .withMessage("랜덤 값은 1 ~ 9까지 수여야 합니다");

    }

    @Test
    @DisplayName("입력값 유효성 검사")
    void isValidTest() {
        assertThat(GameMachine.of().isValid(new String[]{"1", "2", "3"})).isTrue();
        assertThat(GameMachine.of().isValid(new String[]{"4", "5", "6"})).isTrue();
        assertThat(GameMachine.of().isValid(new String[]{"7", "8", "9"})).isTrue();

        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().isValid(new String[]{"a", "b", "c"}))
                .withMessage("랜덤 값은 1 ~ 9까지 수여야 합니다");
        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().isValid(new String[]{"11", "2", "3"}))
                .withMessage("랜덤 값은 1 ~ 9까지 수여야 합니다");
        assertThatIllegalStateException().isThrownBy(() -> GameMachine.of().isValid(new String[]{"1", "2", "2"}))
                .withMessage("중복된 값이 존재합니다");
    }

    @Test
    @DisplayName("입력값 길이 유효성 검사")
    void isValidLengthTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().isValid(new String[]{"1", "2"}))
                .withMessage("입력된 값의 길이는 반드시 3이어야 합니다");

        assertThatIllegalArgumentException().isThrownBy(() -> GameMachine.of().isValid(new String[]{"1", "2", "3", "4"}))
                .withMessage("입력된 값의 길이는 반드시 3이어야 합니다");
    }

    @Test
    @DisplayName("검사 하기")
    void checkTest() {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init(new int[]{1, 2, 3});

        String[] input1 = new String[]{"1", "2", "4"}; // 2스트라이크
        String[] input2 = new String[]{"1", "4", "2"}; // 1스트라이크 1볼
        String[] input3 = new String[]{"7", "8", "9"}; // 낫싱
        String[] input4 = new String[]{"3", "8", "9"}; // 1볼
        String[] input5 = new String[]{"1", "2", "3"}; // 3스트라이크

        assertThat(gameMachine.check(input1)).isEqualTo(new int[]{2, 0, 1});
        assertThat(gameMachine.check(input2)).isEqualTo(new int[]{1, 1, 1});
        assertThat(gameMachine.check(input3)).isEqualTo(new int[]{0, 0, 3});
        assertThat(gameMachine.check(input4)).isEqualTo(new int[]{0, 1, 2});
        assertThat(gameMachine.check(input5)).isEqualTo(new int[]{3, 0, 0});
    }

    @Test
    @DisplayName("검사 결과 출력")
    void printTest() {
        GameMachine gameMachine = GameMachine.of();
        assertThat(gameMachine.print(new int[]{2, 0, 1})).isEqualTo("2스트라이크");
        assertThat(gameMachine.print(new int[]{1, 1, 1})).isEqualTo("1스트라이크 1볼");
        assertThat(gameMachine.print(new int[]{0, 0, 3})).isEqualTo("낫싱");
        assertThat(gameMachine.print(new int[]{0, 1, 2})).isEqualTo("1볼");
        assertThat(gameMachine.print(new int[]{3, 0, 0})).isEqualTo("3스트라이크");
    }
}