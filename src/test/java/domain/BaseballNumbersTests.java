package domain;

import domain.exceptions.InvalidBaseballNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static fixtures.FakeBaseballNumbers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTests {
    @DisplayName("BaseballNumber 컬렉션을 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO, BaseballNumber.FIVE)))
                .isNotNull();
    }

    @DisplayName("size가 3이 아닌 컬렉션으로 생성 시 예외가 발생한다")
    @Test
    void createFailTest() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO)))
                .isInstanceOf(InvalidBaseballNumbersSizeException.class);
    }

    @DisplayName("전달된 BaseballNumbers 일급컬렉션과 비교하여 일치하는 BaseballNumber 수를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("countMatchResource")
    void countMatchTest(BaseballNumbers baseballNumbers, BaseballNumbers compareTarget, int expectedResult) {
        assertThat(baseballNumbers.countMatchNumbers(compareTarget)).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> countMatchResource() {
        return Stream.of(
                Arguments.of(ONE_TWO_THREE, ONE_FIVE_NINE, 1),
                Arguments.of(ONE_TWO_FIVE, ONE_FIVE_NINE, 2)
        );
    }

    @DisplayName("전달된 BaseballNumbrers 일급컬렉션과 비교하여 index까지 일치하는 BaseballNumber 수를 계산핳 수 있다.")
    @ParameterizedTest
    @MethodSource("countExactMatchResource")
    void countExactMatchTest(BaseballNumbers first, BaseballNumbers second, int expectedResult) {
        assertThat(first.countExactMatch(second)).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> countExactMatchResource() {
        return Stream.of(
                Arguments.of(ONE_TWO_FIVE, ONE_FIVE_NINE, 1),
                Arguments.of(ONE_TWO_FIVE, ONE_NINE_FIVE, 2),
                Arguments.of(ONE_TWO_FIVE, ONE_THREE_TWO, 1),
                Arguments.of(ONE_TWO_FIVE, ONE_TWO_THREE, 2)
        );
    }
}
