package baseball.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TrialResultValidatorTest {
    private static Validatable<Integer> validator;

    @BeforeAll
    static void beforeAll() {
        validator = new TrialResultValidator();
    }

    @DisplayName("isValid() 테스트 - null 케이스")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @NullSource
    void isValidForNull(Integer target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() 테스트 - invalid 케이스")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @ValueSource(ints = {-1, 4, 5})
    void isValidForInvalidNumbers(Integer target) {
        assertThat(validator.isValid(target)).isFalse();
    }

    @DisplayName("isValid() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - target={0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void isValid(Integer target) {
        assertThat(validator.isValid(target)).isTrue();
    }
}