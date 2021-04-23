import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallRefereeTest {
    @Test
    @DisplayName("투수, 타자의 공수 스코어 판단 (낫싱)")
    void judgeGame_Nothing() {
        int expectedStrike = 0;
        String pitcherNumber = "123";
        String batterNumber = "456";
        BaseBallReferee baseBallReferee = new BaseBallReferee();
        int strikeCount = baseBallReferee.judgeGame(pitcherNumber, batterNumber);

        assertEquals(strikeCount, expectedStrike);
    }

    @Test
    @DisplayName("투수, 타자의 공수 스코어 판단 (strike all)")
    void judgeGame_StrikeAll() {
        int expectedStrike = PlayGame.RANDOM_NUMBER_LENGTH;
        String pitcherNumber = "123";
        String batterNumber = "123";
        BaseBallReferee baseBallReferee = new BaseBallReferee();
        int strikeCount = baseBallReferee.judgeGame(pitcherNumber, batterNumber);

        assertEquals(strikeCount, expectedStrike);
    }

    @Test
    @DisplayName("투수, 타자의 공수 스코어 판단 (ball and strike)")
    void judgeGame_BallAndStrike() {
        int expectedStrike = 1;
        String pitcherNumber = "123";
        String batterNumber = "132";
        BaseBallReferee baseBallReferee = new BaseBallReferee();
        int strikeCount = baseBallReferee.judgeGame(pitcherNumber, batterNumber);

        assertEquals(strikeCount, expectedStrike);
    }

    @Test
    @DisplayName("투수, 타자의 공수 스코어 판단 (ball only)")
    void judgeGame_BallOnly() {
        int expectedStrike = 0;
        String pitcherNumber = "123";
        String batterNumber = "231";
        BaseBallReferee baseBallReferee = new BaseBallReferee();
        int strikeCount = baseBallReferee.judgeGame(pitcherNumber, batterNumber);

        assertEquals(strikeCount, expectedStrike);
    }
}
