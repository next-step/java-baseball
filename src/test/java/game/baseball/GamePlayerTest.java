package game.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import common.models.PlayResultModel;
import common.models.ThreeNumbers;

public class GamePlayerTest {
	
	GamePlayer gamePlayer = new GamePlayer();
	
	@Test
	@DisplayName("game start test")
	void test_start() {
		ThreeNumbers defendNumbers = gamePlayer.startGame();
		
		// null test
		assertNotNull(defendNumbers, "생성된 defend number은 null이어서는 안된다.");
	}
	
	@Test
	@DisplayName("game play test")
	void test_play() {
		ThreeNumbers defendNumbers = gamePlayer.startGame();
		
		// play game
		ThreeNumbers attackNumbers1 = new ThreeNumbers(
				defendNumbers.getNumber(0), defendNumbers.getNumber(2), defendNumbers.getNumber(1));
		
		PlayResultModel playReulst1 = gamePlayer.playGame(attackNumbers1);
		assertFalse(playReulst1.isFinish());
		assertEquals("스트라이크1개 볼2개", playReulst1.getResultMessage());
		
		ThreeNumbers attackNumbers2 = new ThreeNumbers(
				defendNumbers.getNumber(0), defendNumbers.getNumber(1), 0);
		
		PlayResultModel playReulst2 = gamePlayer.playGame(attackNumbers2);
		assertFalse(playReulst2.isFinish());
		assertEquals("스트라이크2개", playReulst2.getResultMessage());
		
		// 3Strkie, finish game
		PlayResultModel finishResult = gamePlayer.playGame(defendNumbers);
		assertTrue(finishResult.isFinish());
		
	}
}
