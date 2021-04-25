package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallGameTest {
    private final BaseBallGame baseBallGame = new BaseBallGame();

    @Test
    @DisplayName("3 스트라이크이면 정답이다")
    public void threeStrikeMeansGuessCorrect() {
        // given
        BaseBallGuessResult guessResult = new BaseBallGuessResult();
        guessResult.setStrikeCount(3);

        // when, then
        assertTrue(baseBallGame.isGuessCorrect(guessResult));
    }
}