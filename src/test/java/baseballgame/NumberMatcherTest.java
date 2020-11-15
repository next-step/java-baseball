package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMatcherTest {
    NumberMatcher numberMatcher = new NumberMatcher();

    @Test
    @DisplayName("nothing 일 경우")
    void noting() {
        RandomNumber randomNumber = getRandomNumber("123");
        InputNumber inputNumber = getInpuNumber("456");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.NOTHING);
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void strike1_ball1() {
        RandomNumber randomNumber = getRandomNumber("198");
        InputNumber inputNumber = getInpuNumber("183");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.ONE_STRIKE_ONE_BALL);
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void strike1_ball2() {
        RandomNumber randomNumber = getRandomNumber("198");
        InputNumber inputNumber = getInpuNumber("189");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.ONE_STRIKE_TWO_BALL);
    }

    @Test
    @DisplayName("2스트라이크")
    void strike2() {
        RandomNumber randomNumber = getRandomNumber("198");
        InputNumber inputNumber = getInpuNumber("193");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.TWO_STRIKE);
    }

    @Test
    @DisplayName("3스트라이크")
    void strike3() {
        RandomNumber randomNumber = getRandomNumber("198");
        InputNumber inputNumber = getInpuNumber("198");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.THREE_STRIKE);
    }

    @Test
    @DisplayName("3볼")
    void ball3() {
        RandomNumber randomNumber = getRandomNumber("198");
        InputNumber inputNumber = getInpuNumber("981");
        ResultType result = numberMatcher.match(randomNumber, inputNumber);
        assertThat(result).isEqualTo(ResultType.THREE_BALL);
    }

    private InputNumber getInpuNumber(String number) {
        InputNumberConverter converter = new InputNumberConverter();
        return converter.convertToInputNumber(number);
    }

    private RandomNumber getRandomNumber(String number) {
        String[] split = number.split("");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < split.length; i++) {
            numbers.add(Integer.parseInt(split[i]));
        }
        return new RandomNumber(numbers);
    }
}