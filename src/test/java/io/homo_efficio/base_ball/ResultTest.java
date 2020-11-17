package io.homo_efficio.base_ball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {


    @ParameterizedTest(name = "볼 {0}, 스트라이크 {1}, 출력: {2}")
    @MethodSource("params1")
    void 판정_결과_출력_테스트(int balls, int strikes, String resultText) {
        Result result = new Result(balls, strikes, 3);
        assertThat(result.getText()).isEqualTo(resultText);
    }

    private static Stream<Arguments> params1() {
        return Stream.of(
                Arguments.of(1, 0, "1 볼"),
                Arguments.of(2, 0, "2 볼"),
                Arguments.of(3, 0, "3 볼"),
                Arguments.of(1, 1, "1 스트라이크 1 볼"),
                Arguments.of(1, 2, "2 스트라이크 1 볼"),
                Arguments.of(0, 1, "1 스트라이크"),
                Arguments.of(0, 2, "2 스트라이크"),
                Arguments.of(0, 3, "3 스트라이크")
        );
    }

    @ParameterizedTest(name = "볼 {0}, 스트라이크 {1}, isAllStrike: {2}")
    @MethodSource("params2")
    void 모두_스트라이크면_isAllStrikes_True(int balls, int strikes, boolean isAllStrikes) {
        Result result = new Result(balls, strikes, strikes);
        assertThat(result.isAllStrikes()).isTrue();
    }

    private static Stream<Arguments> params2() {
        return IntStream.range(1, 10)
                .mapToObj(i -> Arguments.of(0, i, true));
    }

    @ParameterizedTest(name = "볼 {0}, 스트라이크 {1}, isAllStrike: {2}")
    @MethodSource("params3")
    void 볼이_하나라도_있으면_isAllStrikes_False(int balls, int strikes, boolean isAllStrikes) {
        Result result = new Result(balls, strikes, balls + strikes);
        assertThat(result.isAllStrikes()).isFalse();
    }

    private static Stream<Arguments> params3() {
        return IntStream.range(1, 10)
                .mapToObj(i -> Arguments.of(1, i, false));
    }
}
