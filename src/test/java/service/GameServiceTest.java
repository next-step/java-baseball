package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private GameService gameService = new GameService();

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
        System.out.println(Arrays.toString(result));
    }
}
