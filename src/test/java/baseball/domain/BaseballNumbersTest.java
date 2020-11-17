package baseball.domain;

import baseball.exception.DuplicationException;
import baseball.exception.NumberDigitException;
import baseball.exception.NumberZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballNumbersTest {

    @DisplayName("생성")
    @Test
    void 생성() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);

        // then
        assertThat(baseballNumbers.get(0)).isEqualTo(1);
        assertThat(baseballNumbers.get(1)).isEqualTo(2);
        assertThat(baseballNumbers.get(2)).isEqualTo(3);
    }

    @DisplayName("사이즈")
    @Test
    void 사이즈() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);

        // then
        assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @DisplayName("예외1 : 입력값 자리수 != 3자리 (초)")
    @Test
    void 예외1_자리수_초과() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // then
        assertThatExceptionOfType(NumberDigitException.class)
                .isThrownBy(() -> {
                    new BaseballNumbers(numbers);
                });
    }

    @DisplayName("예외1: 입력값 자리수 != 3자리 (미달)")
    @Test
    void 예외1_자리수_미달() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        // then
        assertThatExceptionOfType(NumberDigitException.class)
                .isThrownBy(() -> {
                    new BaseballNumbers(numbers);
                });
    }

    @DisplayName("예외2: 입력값 중복 금지")
    @Test
    void 예외2_입력값_중복() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);

        // then
        assertThatExceptionOfType(DuplicationException.class)
                .isThrownBy(() -> {
                    new BaseballNumbers(numbers);
                });
    }

    @DisplayName("예외3: 입력값 0 포함 금지")
    @Test
    void 예외3_입력값_0_포함() {
        // given/when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(0);
        numbers.add(2);

        // then
        assertThatExceptionOfType(NumberZeroException.class)
                .isThrownBy(() -> {
                    new BaseballNumbers(numbers);
                });
    }
}