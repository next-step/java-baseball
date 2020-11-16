package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 점수 테스트")
public class GameScoreTest {

    @DisplayName("게임 성적 계산 > 성공")
    @Test
    public void checkGameScore(){
        String[] randomNumbers = new String[] {"3","1","4"};
        GameScore gameScore = new GameScore();

        gameScore.checkGameScore(randomNumbers, "314");
        assertEquals(3, gameScore.getStrike());
        assertEquals(0, gameScore.getBall());

        gameScore.checkGameScore(randomNumbers, "312");
        assertEquals(2, gameScore.getStrike());
        assertEquals(0, gameScore.getBall());

        gameScore.checkGameScore(randomNumbers, "124");
        assertEquals(1, gameScore.getStrike());
        assertEquals(1, gameScore.getBall());
    }
}

