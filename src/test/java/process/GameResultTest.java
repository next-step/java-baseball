package process;

import logic.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    @Test
    void gameResult객체가_STRIKE만있을경우_isGameEnd가_TRUE를_반환한다() {
        // given
        GameResult gameResult = new GameResult();

        // when
        for (int i = 0; i< Answer.ANSWER_SIZE; i++) {
            gameResult.addStrike();
        }

        //then
        assertTrue(gameResult.isGameEnd());
    }

    @Test
    void gameResult객체가_BALL이_한개라도있을경우_isGameEnd가_FALSE를_반환한다() {
        // given
        GameResult gameResult = new GameResult();

        // when
        for (int i = 0; i< Answer.ANSWER_SIZE - 1; i++) {
            gameResult.addStrike();
        }
        gameResult.addBall();

        //then
        assertFalse(gameResult.isGameEnd());
    }


    @Test
    void gameResult객체가_Strike가_한개부족할경우_false를_반환한다() {
        // given
        GameResult gameResult = new GameResult();

        // when
        for (int i = 0; i< Answer.ANSWER_SIZE - 1; i++) {
            gameResult.addStrike();
        }

        //then
        assertFalse(gameResult.isGameEnd());
    }


}