package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.GameStatus;

class MatchCheckerTest {
	
    @DisplayName("컴퓨터의 수와 사용자의 수 비교")
    @Test
    public void testCreateNumber() {
        Baseball answerBall = new Baseball("123");
        Baseball inputBall = new Baseball("142");
        MatchChecker result = new MatchChecker(answerBall, inputBall);
        assertThat(result.getStrike() == 1).isTrue();
        assertThat(result.getBall() == 1).isTrue();
    }

}
