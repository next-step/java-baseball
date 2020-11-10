package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTests {
    @DisplayName("1 ~ 9 사이의 숫자로 객체 생성 시도시 알맞는 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("createBaseballNumberResource")
    void createBaseballNumberTest(int number, BaseballNumber expectedNumber) {
        assertThat(BaseballNumber.of(number)).isEqualTo(expectedNumber);
    }
    public static Stream<Arguments> createBaseballNumberResource() {
        return Stream.of(
                Arguments.of(1, BaseballNumber.ONE),
                Arguments.of(2, BaseballNumber.TWO),
                Arguments.of(3, BaseballNumber.THREE),
                Arguments.of(4, BaseballNumber.FOUR),
                Arguments.of(5, BaseballNumber.FIVE),
                Arguments.of(6, BaseballNumber.SIX),
                Arguments.of(7, BaseballNumber.SEVEN),
                Arguments.of(8, BaseballNumber.EIGHT),
                Arguments.of(9, BaseballNumber.NINE)
        );
    }
}
