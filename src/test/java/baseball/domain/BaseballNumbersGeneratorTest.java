package baseball.domain;

import baseball.exception.NumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballNumbersGeneratorTest {

    private static final int DECIMAL = 10;

    @DisplayName("컴퓨터번호 생성")
    @Test
    void 컴퓨터번호_생성() {
        BaseballNumbersGenerator baseballNumbersGenerator = new BaseballNumbersGenerator();
        baseballNumbersGenerator.generateComputerNumbers();

    }

    @DisplayName("사용자번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {123,456,789})
    void 사용자번호_생성(int input) {
        // given
        BaseballNumbersGenerator baseballNumbersGenerator = new BaseballNumbersGenerator();

        // when
        BaseballNumbers userNumbers = baseballNumbersGenerator.generateUserNumbers(input);

        // then
        List<Integer> numbers = convertIntToList(input);
        for (int i = 0; i < numbers.size(); i++) {
            assertThat(numbers.get(i)).isEqualTo(userNumbers.get(i));
        }

    }

    @DisplayName("사용자번호 예외1: 입력값 음수 금지")
    @Test
    void 사용자번호_예외1_입력값_음수() {
        // given/when
        int input = -1;
        BaseballNumbersGenerator baseballNumbersGenerator = new BaseballNumbersGenerator();

        // then
        assertThatExceptionOfType(NumberRangeException.class)
                .isThrownBy(() -> {
                    baseballNumbersGenerator.generateUserNumbers(input);
                });
    }

    @DisplayName("사용자번호 예외2: 입력값 문자 금지")
    @ParameterizedTest
    @ValueSource(strings = {"111", "abc", "1ab"})
    void 사용자번호_예외1_입력값_문자() {
        // given/when
        int input = -1;
        BaseballNumbersGenerator baseballNumbersGenerator = new BaseballNumbersGenerator();

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    baseballNumbersGenerator.generateUserNumbers(input);
                });
    }

    public List<Integer> convertIntToList(int input) {
        List<Integer> numbers = new ArrayList<>();
        while (input > 0) {
            numbers.add(0, input % DECIMAL);
            input /= DECIMAL;
        }
        return numbers;
    }
}