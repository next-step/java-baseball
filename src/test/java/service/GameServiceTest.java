package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import support.ConvertUtils;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private GameService gameService = new GameService();
    private static final int LEN = 3;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @DisplayName("Random bot numbers should be generated")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testGenerateBotNumber(int len) {
        int[] result = gameService.generateBotNumber(len);
        assertThat(result).hasSize(len);
        System.out.println(ConvertUtils.convertArrayToInt(result));
    }

    @DisplayName("isValidInput should return true")
    @ParameterizedTest
    @ValueSource(strings = {"123", "111", "456"})
    void testIsValidInputReturnTrue(String input) {
        assertThat(gameService.isValidInput(input, LEN)).isTrue();
    }

    @DisplayName("isValidInput should return false")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "abc"})
    void testIsValidInputReturnFalse(String input) {
        assertThat(gameService.isValidInput(input, LEN)).isFalse();
    }

}
