package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.ApplicationContext.EMPTY_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;


class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("Numbers.SIZE 갯수와 다른 값이라면 inValidate true를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "4567", "1123"})
    void numberSizeTest(final String value) {
        final List<String> numbers = getNumbers(value);
        assertThat(validator.inValidate(numbers)).isTrue();
    }

    @DisplayName("중복된 값이 있다면 inValidate true를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"112", "445", "575"})
    void numberDuplicateTest(final String value) {
        final List<String> numbers = getNumbers(value);
        assertThat(validator.inValidate(numbers)).isTrue();
    }

    @DisplayName("Numbers.SIZE 갯수와 같고 중복된 값이 없다면 inValidate false를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "729", "912"})
    void numberOK(final String value) {
        final List<String> numbers = getNumbers(value);
        assertThat(validator.inValidate(numbers)).isFalse();
    }

    private ArrayList<String> getNumbers(String value) {
        return new ArrayList<>(Arrays.asList(value.split(EMPTY_DELIMITER)));
    }

}
