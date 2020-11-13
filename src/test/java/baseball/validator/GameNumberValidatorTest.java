package baseball.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberValidatorTest {
    private static Validatable<Integer> validator;

    @BeforeAll
    static void beforeAll() {
        validator = new GameNumberValidator();
    }

    @DisplayName("isValid() - null 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @NullSource
    void isValidForNull(Integer target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() - invalid 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @ValueSource(ints = {-1, 0, 10, 11})
    void isValidForInvalidNumbers(Integer target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isValid(Integer target) {
        assertThat(validator.isValid(target)).isTrue();
    }
}