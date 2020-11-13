package baseball.validator;

import baseball.domain.GameNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputNumbersValidatorTest {
    private static Validatable<Set<GameNumber>> validator;

    @BeforeAll
    static void beforeAll() {
        validator = new InputNumbersValidator();
    }

    static Stream<Arguments> generateInvalidData() {
        return Stream.of(
            Arguments.of(new HashSet<>()),
            Arguments.of(getGameNumbers(Arrays.asList(1))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 2))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 1, 1, 4))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 2, 3, 4))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 1, 3, 4, 5)))
        );
    }

    static Stream<Arguments> generateValidData() {
        return Stream.of(
            Arguments.of(getGameNumbers(Arrays.asList(1, 2, 3))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 1, 2, 3))),
            Arguments.of(getGameNumbers(Arrays.asList(1, 1, 1, 2, 3)))
        );
    }

    private static Set<GameNumber> getGameNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(GameNumber::getInstance)
            .collect(Collectors.toSet());
    }

    @DisplayName("isValid() 테스트 - null 케이스")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @NullSource
    void isValidForNull(Set<GameNumber> target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() 테스트 - invalid 케이스")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @MethodSource("generateInvalidData")
    void isValidForInvalidNumbers(Set<GameNumber> target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @MethodSource("generateValidData")
    void isValid(Set<GameNumber> target) {
        assertThat(validator.isValid(target)).isTrue();
    }
}