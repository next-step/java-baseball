package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.domain.Score;
import baseball.domain.enums.ScoreStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.BaseballNumbers.RANDOM_NUMBER_COUNT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("야구_게임_서비스")
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
    @DisplayName("점수_측정_서비스_메소드/1_스트라이크인_경우_테스트")
    @ValueSource(strings = {"123,145", "421,325", "137,247"})
    void testScorePlayerInputWhenOneStrike(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];
        int oneStrike = 1;

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertTrue(score.hasStrike());
        assertEquals(oneStrike, score.getStrike());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/2_스트라이크인_경우_테스트")
    @ValueSource(strings = {"123,125", "421,521", "137,147"})
    void testScorePlayerInputWhenTwoStrike(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];
        int twoStrike = 2;

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertTrue(score.hasStrike());
        assertEquals(twoStrike, score.getStrike());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/1_볼인_경우_테스트")
    @ValueSource(strings = {"123,415", "421,352", "137,274"})
    void testScorePlayerInputWhenOneBall(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];
        int oneBall = 1;

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertTrue(score.hasBall());
        assertEquals(oneBall, score.getBall());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/1_스트라이크_1_볼인_경우_테스트")
    @ValueSource(strings = {"123,142", "421,251", "137,417"})
    void testScorePlayerInputWhenOneStrikeOneBall(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];
        int oneStrike = 1;
        int oneBall = 1;

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertTrue(score.hasStrike());
        assertEquals(oneStrike, score.getStrike());
        assertTrue(score.hasBall());
        assertEquals(oneBall, score.getBall());
    }

    @ParameterizedTest
    @DisplayName("점수_측정_서비스_메소드/낫싱인_경우_테스트")
    @ValueSource(strings = {"312,645", "421,378", "375,164"})
    void testScorePlayerInputWhenNothing(String arg) {
        // Given
        String[] argArray = arg.split(",");
        BaseballNumbers answer = new BaseballNumbers(argArray[0]);
        String playerInput = argArray[1];

        // When
        Score score = baseballService.scorePlayerInput(answer, playerInput);

        // Then
        assertTrue(score.isNothing());
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