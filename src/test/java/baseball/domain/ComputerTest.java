package baseball.domain;

import baseball.generator.TestAnswerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerTest {

    @DisplayName("3자리 숫자를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource(value = {"1234", "12", "1", "12345"})
    void check_size_exception(String input) {
        // given
        Computer computer = Computer.from(new TestAnswerGenerator());
        String[] digits = input.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String digit : digits) {
            numbers.add(Integer.valueOf(digit));
        }

        // when

        // then
        assertThatThrownBy(() -> computer.play(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자를 입력하셔야 합니다.");
    }

    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다")
    @Test
    void check_duplicate_exception() {
        // given
        Computer computer = Computer.from(new TestAnswerGenerator());
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        // when

        // then
        assertThatThrownBy(() -> computer.play(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 입력하실 수 없습니다.");
    }

    @DisplayName("숫자를 입력하고 play 하면 strike or ball 을 판단한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,3,0", "1,3,2,1,2", "2,3,1,0,3", "3,2,1,1,2"})
    void play(int firstNum, int secondNum, int thirdNum, int expectedStrikeCount, int expectedBallCount) {
        // given
        Computer computer = Computer.from(new TestAnswerGenerator());
        List<Integer> numbers = Arrays.asList(firstNum, secondNum, thirdNum);

        // when
        computer.play(numbers);

        // then
        assertThat(computer.getStrike()).isEqualTo(expectedStrikeCount);
        assertThat(computer.getBall()).isEqualTo(expectedBallCount);
    }

    @DisplayName("3스트라이크 일때 모두 스트라이크인지 물어보면 true 반환, 그렇지 않을 경우 false 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "1,3,2,false"})
    void isAllStrike(int firstNum, int secondNum, int thirdNum, boolean expected) {
        // given
        Computer computer = Computer.from(new TestAnswerGenerator());
        List<Integer> numbers = Arrays.asList(firstNum, secondNum, thirdNum);

        // when
        computer.play(numbers);

        // then
        assertThat(computer.isAllStrike()).isEqualTo(expected);
    }
}
