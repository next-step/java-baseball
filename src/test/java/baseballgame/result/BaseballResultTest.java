package baseballgame.result;

import baseballgame.number.AnswerNumber;
import baseballgame.number.BaseballNumber;
import baseballgame.number.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultTest {

    @DisplayName("스트라이크와 볼 카운트 체크")
    @ParameterizedTest
    @MethodSource("provideInputList")
    void check(int expectedStrikeCount, int expectedBallCount, List<String> input) {
        //given
        BaseballNumber inputNumber = new InputNumber(input);
        BaseballNumber answerNumber = new AnswerNumber(Arrays.asList("1", "2", "3"));

        //when
        BaseballResult baseballResult = new BaseballResult(inputNumber, answerNumber);
        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();
        String message = baseballResult.getMessage();

        //then
        assertThat(strikeCount).isEqualTo(expectedStrikeCount);
        assertThat(ballCount).isEqualTo(expectedBallCount);
        assertThat(message).isNotEmpty();
    }

    // 스트라이크 카운트, 볼카운트, 입력숫자
    static Stream<Arguments> provideInputList() {
        return Stream.of(
                Arguments.of(0, 0, Arrays.asList("7", "8", "9")),
                Arguments.of(1, 0, Arrays.asList("1", "8", "9")),
                Arguments.of(2, 0, Arrays.asList("1", "2", "9")),
                Arguments.of(3, 0, Arrays.asList("1", "2", "3")),
                Arguments.of(0, 1, Arrays.asList("7", "8", "1")),
                Arguments.of(0, 2, Arrays.asList("7", "1", "2")),
                Arguments.of(0, 3, Arrays.asList("3", "1", "2")),
                Arguments.of(1, 1, Arrays.asList("1", "7", "2")),
                Arguments.of(1, 2, Arrays.asList("1", "3", "2"))
        );
    }

    @DisplayName("3스트라이크 시 게임 클리어 확인")
    @Test
    void isClear() {
        //given
        List<String> number = Arrays.asList("1", "2", "3");
        BaseballNumber inputNumber = new InputNumber(number);
        BaseballNumber answerNumber = new AnswerNumber(number);

        //when
        BaseballResult baseballResult = new BaseballResult(inputNumber, answerNumber);
        boolean isClear = baseballResult.isClear();

        //then
        assertThat(isClear).isTrue();
    }

}