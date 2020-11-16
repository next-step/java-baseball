package baseball.domain;

import baseball.exception.IncorrectNumbersException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    static Stream<Arguments> emptyArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {}));
    }

    @ParameterizedTest
    @MethodSource("emptyArrayProvider")
    void isEmpty_validateNumbersTest(Integer[] inputNumbers) {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(inputNumbers)))
                .isInstanceOf(IncorrectNumbersException.class)
                .hasMessageContaining("비었습니다.");
    }

    static Stream<Arguments> notAllowedArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {12, 13, 9}),
                Arguments.of((Object) new Integer[] {2, 33, 1}));
    }

    @ParameterizedTest
    @MethodSource("notAllowedArrayProvider")
    void isAllowed_validateNumbersTest(Integer[] inputNumbers) {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(inputNumbers)))
                .isInstanceOf(IncorrectNumbersException.class)
                .hasMessageContaining("허용되지 않은 숫자");
    }

    static Stream<Arguments> duplicatedArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {1, 1, 9}),
                Arguments.of((Object) new Integer[] {2, 3, 3}));
    }

    @ParameterizedTest
    @MethodSource("duplicatedArrayProvider")
    void isDuplicated_validateNumbersTest(Integer[] inputNumbers) {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(inputNumbers)))
                .isInstanceOf(IncorrectNumbersException.class)
                .hasMessageContaining("중복");
    }
}
