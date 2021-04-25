package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"2345", "12", "1"})
    @DisplayName("입력한 숫자 길이가 3보다 크거나 작을 시 예외 발생")
    void whenInputNotValidNumberLengthThenExceptionTest(String numbers) {

        // then
        assertNumbersThrowIllegalArgumentException(numbers, ErrorCode.NUMBER_LENGTH_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "122", "331"})
    @DisplayName("입력한 숫자에 중복이 있을 시 예외 발생")
    void whenInputDuplicatedNumberThenExceptionTest(String numbers) {

        // then
        assertNumbersThrowIllegalArgumentException(numbers, ErrorCode.NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0,214,true", "2,1,234,true", "3,2,354,true", "4,2,123,false"})
    @DisplayName("gameNumbers에 입력한 number 가 position 상관없이 포함되어 있는지 여부 확인")
    void containsEqualsNumberTest(int number, int position, String numbers, boolean expected) {

        // given
        Number inputNumber = Number.of(number, position);
        Numbers gameNumbers = Numbers.of(numbers);

        // when
        boolean result = gameNumbers.contains(inputNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0,214,false", "2,1,234,false", "3,2,354,false", "5,0,579,true", "4,2,123,false"})
    @DisplayName("gameNumbers에 입력한 number 와 position 이 정확히 일치하는 number가 포함되어 있는지 여부 확인")
    void containsEqualsAndHashCodeNumberTest(int number, int position, String numbers, boolean expected) {

        // given
        Number inputNumber = Number.of(number, position);
        Numbers gameNumbers = Numbers.of(numbers);

        // when
        boolean result = gameNumbers.containsExactly(inputNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private void assertNumbersThrowIllegalArgumentException(String numbers, String message) {
        assertThatExceptionOfType(BaseBallGameFailureException.class)
                .isThrownBy(() -> Numbers.of(numbers))
                .withMessageContainingAll(message);
    }
}