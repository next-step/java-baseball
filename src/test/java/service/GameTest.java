package service;

import domain.Bettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName(value = "게임 로직 테스트")
class GameTest {

    @DisplayName(value = "사용자 입력 값과 난수가 동일한 경우 스트라이크")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"123"})
    void game(String input) {
        setSystemInputStream(input);
        Bettings bettings = new Bettings(new ArrayList(Arrays.asList(1,2,3)));
        Game.init();
        Game.setBettings(bettings);
        Game.playGame();
    }

    private void setSystemInputStream(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName(value = "사용자 입력 값으로 게임 종료 여부 판단")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"2", "1"})
    void isGameOver(String input) {
        setSystemInputStream(input);
        assumingThat(input == "2" && Game.isGameOver() == false
                , () -> System.out.println("test success!"));
        assumingThat(input == "1" && Game.isGameOver() == true
                , () -> System.out.println("test success!"));
    }
}