package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.BaseballNumbers.RANDOM_NUMBER_COUNT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("점수_측정_테스트")
class ScoreTest {

    @ParameterizedTest
    @DisplayName("정답인_경우_테스트")
    @ValueSource(strings = {"123", "423", "836"})
    void testPassingCase(String arg) {
        // Given
        BaseballNumbers commonBaseballNumbers = new BaseballNumbers(arg);

        // When
        Score score = Score.measureScore(commonBaseballNumbers, commonBaseballNumbers);

        // Then
        assertTrue(score.isPassed());
    }

    @ParameterizedTest
    @DisplayName("정답인_경우_메시지_확인")
    @ValueSource(strings = {"123", "423", "836"})
    void testPassingMessage(String arg) {
        // Given
        BaseballNumbers commonBaseballNumbers = new BaseballNumbers(arg);

        // When
        Score score = Score.measureScore(commonBaseballNumbers, commonBaseballNumbers);

        // Then
        assertEquals(format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", RANDOM_NUMBER_COUNT), score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("1_스트라이크인_경우_메시지_확인")
    @ValueSource(strings = {"123,145", "421,325", "137,247"})
    void testOneStrikeMessage(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        BaseballNumbers playerInput = new BaseballNumbers(argArray[1]);

        // When
        Score score = Score.measureScore(answer, playerInput);

        // Then
        assertEquals("1 스트라이크", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("2_스트라이크인_경우_메시지_확인")
    @ValueSource(strings = {"123,125", "421,521", "137,147"})
    void testTwoStrikeMessage(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        BaseballNumbers playerInput = new BaseballNumbers(argArray[1]);

        // When
        Score score = Score.measureScore(answer, playerInput);

        // Then
        assertEquals("2 스트라이크", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("1_볼인_경우_메시지_확인")
    @ValueSource(strings = {"123,415", "421,352", "137,274"})
    void testOneBallMessage(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        BaseballNumbers playerInput = new BaseballNumbers(argArray[1]);

        // When
        Score score = Score.measureScore(answer, playerInput);

        // Then
        assertEquals("1 볼", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("1_스트라이크_1_볼인_경우_메시지_확인")
    @ValueSource(strings = {"123,142", "421,251", "137,417"})
    void testOneStrikeOneBallMessage(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        BaseballNumbers playerInput = new BaseballNumbers(argArray[1]);

        // When
        Score score = Score.measureScore(answer, playerInput);

        // Then
        assertEquals("1 스트라이크 1 볼", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("낫싱인_경우_메시지_확인")
    @ValueSource(strings = {"312,645", "421,378", "375,164"})
    void testNothingMessage(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        BaseballNumbers playerInput = new BaseballNumbers(argArray[1]);

        // When
        Score score = Score.measureScore(answer, playerInput);

        // Then
        assertEquals("낫싱", score.getJudgeMessage());
    }
}