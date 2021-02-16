package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("스트라이크 볼 정보에 따른 결과를 잘 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("providerOfParams")
    void of(int strike, int ball, Result result) {
        assertEquals(
            result,
            Result.of(strike, ball)
        );
    }

    private static Stream<Arguments> providerOfParams() {
        return Stream.of(
            Arguments.of(3, 0, Result.OUT),
            Arguments.of(0, 0, Result.NOTHING),
            Arguments.of(1, 0, Result.STRIKE_ONLY),
            Arguments.of(0, 1, Result.BALL_ONLY),
            Arguments.of(1, 1, Result.BALL_AND_STRIKE)
        );
    }

    @DisplayName("스트라이크 볼 정보에 따른 결과 리스트를 잘 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("providerFormatParams")
    void format(Result result, List<String> formatted) {
        assertEquals(
            formatted,
            result.format(1, 1)
        );
    }

    private static Stream<Arguments> providerFormatParams() {
        return Stream.of(
            Arguments.of(Result.OUT, Arrays.asList("3스트라이크")),
            Arguments.of(Result.NOTHING, Arrays.asList("낫싱")),
            Arguments.of(Result.STRIKE_ONLY, Arrays.asList("1스트라이크")),
            Arguments.of(Result.BALL_ONLY, Arrays.asList("1볼")),
            Arguments.of(Result.BALL_AND_STRIKE, Arrays.asList("1볼", "1스트라이크"))
        );
    }
}