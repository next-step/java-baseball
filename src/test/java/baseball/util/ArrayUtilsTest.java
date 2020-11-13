package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayUtilsTest {

    static Stream<Arguments> generateNotEmptyArrays() {
        return Stream.of(
            Arguments.of("1".toCharArray()),
            Arguments.of("23".toCharArray()),
            Arguments.of("456".toCharArray())
        );
    }

    @DisplayName("isEmpty() - null, empty 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - arr={0}")
    @NullAndEmptySource
    void isEmptyForNullAndEmpty(char[] arr) {
        assertThat(ArrayUtils.isEmpty(arr)).isTrue();
    }

    @DisplayName("isEmpty() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - arr={0}")
    @MethodSource("generateNotEmptyArrays")
    void isEmpty(char[] arr) {
        assertThat(ArrayUtils.isEmpty(arr)).isFalse();
    }
}