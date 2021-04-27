import exception.BaseballException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ValidateNumbers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("숫자 유효성 검증")
public class ValidateNumbersTest {

    @Test
    @DisplayName("요소들이 중복이면 에러 전달")
    void notBeDuplicatedException() {
        List<Integer> numbers = Arrays.asList(1, 1, 2);

        assertThatExceptionOfType(BaseballException.NotBeDuplicatedException.class)
                .isThrownBy(() -> new ValidateNumbers(numbers).checkNotBeDuplicated())
                .withMessageMatching(BaseballException.DUPLICATED_ERROR);
    }

    @Test
    @DisplayName("투수가 입력한 배열의 요소중 1~9 범위에 없는 숫자가 있다면 에러 전달")
    void outOfRange() {
        List<Integer> numbers = Arrays.asList(0, 10, 5);

        assertThatExceptionOfType(BaseballException.PitcherNumberInputOutOfRangeException.class)
                .isThrownBy(() -> new ValidateNumbers(numbers).checkOutOfRange())
                .withMessageMatching(BaseballException.OUT_OF_RANGE_NUMBER_ERROR);
    }

    @Test
    @DisplayName("투수가 입력한 배열의 크기가 3보다 크면 에러 전달")
    void digitsExceeded() {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1);

        assertThatExceptionOfType(BaseballException.DigitsException.class)
                .isThrownBy(() -> new ValidateNumbers(numbers).checkDigits())
                .withMessageMatching(BaseballException.DIGITS_ERROR);
    }

    @Test
    @DisplayName("투수가 입력한 배열의 크기가 3보다 작으면 에러 전달")
    void digitsLess() {
        List<Integer> numbers = Arrays.asList(1, 1);

        assertThatExceptionOfType(BaseballException.DigitsException.class)
                .isThrownBy(() -> new ValidateNumbers(numbers).checkDigits())
                .withMessageMatching(BaseballException.DIGITS_ERROR);
    }
}
