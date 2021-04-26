package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballNumbersTest {


    private BaseballNumbers makeNormalBaseballNumber(int number1, int number2, int number3) {
        List<Integer> initNumbers = Arrays.asList(number1, number2, number3);
        return BaseballNumbers.create(initNumbers);
    }

    @DisplayName("BaseballNumber 객체 생성확인")
    @ParameterizedTest
    @CsvSource(value = {"8,3,7"}, delimiter = ',')
    void createBaseballNumbersTest(int number1, int number2, int number3) {
        BaseballNumbers baseballNumbers = makeNormalBaseballNumber(number1, number2, number3);

        assertThat(baseballNumbers.numberOfRound(1)).isEqualTo(8);
        assertThat(baseballNumbers.numberOfRound(2)).isEqualTo(3);
        assertThat(baseballNumbers.numberOfRound(3)).isEqualTo(7);
    }

    @DisplayName("BaseballNumber 객체 생성 실패확인(갯수가 다를때)")
    @ParameterizedTest
    @CsvSource(value = {"8,7"}, delimiter = ',')
    void createBaseballNumbersExceptionTest(int number1, int number2) {
        List<Integer> initNumbers = Arrays.asList(number1, number2);
        assertThatThrownBy(() -> {
            BaseballNumbers.create(initNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BaseballNumber 객체 생성 실패확인(범위가 잘못되었을때)")
    @ParameterizedTest
    @CsvSource(value = {"8,7,-1"}, delimiter = ',')
    void baseballNumbersInvalidRangeExceptionTest(int number1, int number2) {
        List<Integer> initNumbers = Arrays.asList(number1, number2);
        assertThatThrownBy(() -> {
            BaseballNumbers.create(initNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BaseballNumber에 숫자가 포함여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"8,3,7"}, delimiter = ',')
    void containsBaseballNumbersTest(int number1, int number2, int number3) {
        BaseballNumbers baseballNumbers = makeNormalBaseballNumber(number1, number2, number3);

        assertTrue(baseballNumbers.contains(number1));
        assertTrue(baseballNumbers.contains(number2));
        assertTrue(baseballNumbers.contains(number3));
    }

    @DisplayName("BaseballNumber와 Pitching이 동일한 위치와 숫자인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"8,3,7"}, delimiter = ',')
    void isSameBaseballNumbersTest(int number1, int number2, int number3) {
        BaseballNumbers baseballNumbers = makeNormalBaseballNumber(number1, number2, number3);
        Pitching pitching1 = Pitching.create(1, number1);
        Pitching pitching2 = Pitching.create(2, number2);
        Pitching pitching3 = Pitching.create(3, number3);

        assertTrue(baseballNumbers.isSameIndex(pitching1));
        assertTrue(baseballNumbers.isSameIndex(pitching2));
        assertTrue(baseballNumbers.isSameIndex(pitching3));
    }
}
