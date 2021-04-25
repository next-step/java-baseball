package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.domain.Score;
import baseball.domain.ScoreStatus;
import baseball.util.BaseballException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.BaseballNumbers.RANDOM_NUMBER_COUNT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("야구 게임 서비스")
class BaseballServiceTest {

    BaseballService baseballService = new BaseballService();

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/정답인_경우_테스트")
    @ValueSource(strings = {"123", "423", "836"})
    void scorePlayerInputWhenCorrectAnswer(String arg) {
        // Given
        BaseballNumbers answer = new BaseballNumbers(arg);

        // When
        Score score = baseballService.scorePlayerInput(answer, arg);

        // Then
        assertTrue(score.isPassed());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/정답인_경우_메시지_테스트")
    @ValueSource(strings = {"123", "423", "836"})
    void testScorePlayerInputWhenCorrectAnswer(String arg) {
        // Given
        BaseballNumbers answer = new BaseballNumbers(arg);

        // When
        Score score = baseballService.scorePlayerInput(answer, arg);

        // Then
        assertEquals(format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", RANDOM_NUMBER_COUNT), score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/1_스트라이크인_경우_메시지_테스트")
    @ValueSource(strings = {"123,145", "421,325", "137,247"})
    void testScorePlayerInputWhenOneStrike(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertEquals("1 스트라이크", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/2_스트라이크인_경우_메시지_테스트")
    @ValueSource(strings = {"123,125", "421,521", "137,147"})
    void testScorePlayerInputWhenTwoStrike(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertEquals("2 스트라이크", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/1_볼인_경우_메시지_테스트")
    @ValueSource(strings = {"123,415", "421,352", "137,274"})
    void testScorePlayerInputWhenOneBall(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertEquals("1 볼", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/1_스트라이크_1_볼인_경우_메시지_테스트")
    @ValueSource(strings = {"123,142", "421,251", "137,417"})
    void testScorePlayerInputWhenOneStrikeOneBall(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertEquals("1 스트라이크 1 볼", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/낫싱인_경우_메시지_테스트")
    @ValueSource(strings = {"312,645", "421,378", "375,164"})
    void testScorePlayerInputWhenNothing(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertEquals("낫싱", score.getJudgeMessage());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/비정상_플레이어_입력시_에러_상태_Score_반환_확인")
    @ValueSource(strings = {"a12", "3b4", "45b",
                            "012", "304", "560",
                            "1", "23", "4567", "78912",
                            "111", "223", "454", "566"})
    void testScorePlayerInputWhenIllegalPlayerInput(String arg) {
        // Given
        BaseballNumbers answer = new BaseballNumbers("123");

        // When
        Score score = baseballService.scorePlayerInput(answer, arg);

        // Then
        assertFalse(score.isPassed());
        assertEquals(ScoreStatus.ERROR, score.getScoreStatus());
    }

}