package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideNumbersAndNumberAndResult")
    @DisplayName("Numbers 에 number 가 같은 객체가 존재하는지 여부와 number, position 이 같은 객체가 존재하는지에 따라 Result 값 생성 ")
    void test(GameNumbers gameNumbers, Number number, Result expected) {
        // given
        Result result = Result.findByCondition(gameNumbers.contains(number), gameNumbers.containsExactly(number));

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAndNumberAndResult() {
        return Stream.of(
                Arguments.of(GameNumbers.of("123"), Number.of(1, 0), Result.STRIKE),
                Arguments.of(GameNumbers.of("123"), Number.of(1, 1), Result.BALL),
                Arguments.of(GameNumbers.of("123"), Number.of(4, 1), Result.NOTHING)
        );
    }


}