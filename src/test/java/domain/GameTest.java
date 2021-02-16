package domain;

import dto.ResultData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @DisplayName("턴 진행 정보가 잘 반환되는지 확")
    @ParameterizedTest
    @MethodSource("providerDoTurnParams")
    void doTurn(List<Integer> candidateDigits, List<String> data) {
        Game game = new Game(new Number(Arrays.asList(1, 2, 3)));
        Number candidate = new Number(candidateDigits);

        assertEquals(
            new ResultData(data),
            game.doTurn(candidate)
        );
    }

    private static Stream<Arguments> providerDoTurnParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList("3스트라이크")),
            Arguments.of(Arrays.asList(4, 5, 6), Arrays.asList("낫싱")),
            Arguments.of(Arrays.asList(1, 8, 9), Arrays.asList("1스트라이크")),
            Arguments.of(Arrays.asList(4, 1, 5), Arrays.asList("1볼")),
            Arguments.of(Arrays.asList(8, 2, 1), Arrays.asList("1볼", "1스트라이크"))
        );
    }

    @DisplayName("정답을 맞춘 후 종료 정보가 잘 반영되는지 확인")
    @Test
    void isFinished() {
        Game game = new Game(new Number(Arrays.asList(1, 2, 3)));

        assertEquals(false, game.isFinished());
        game.doTurn(new Number(Arrays.asList(1, 2, 3)));
        assertEquals(true, game.isFinished());
    }
}