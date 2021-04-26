package game.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import common.models.PlayResultModel;

public class GamePlayerTest {
	
	GamePlayer gamePlayer = new GamePlayer();
	
	@Test
	@DisplayName("game start test")
	void test_start() {
		int[] defendNumberArr = gamePlayer.startGame();
		
		// null test
		assertNotNull(defendNumberArr, "생성된 defend number은 null이어서는 안된다.");
		
		// array length test
		assertEquals(3, defendNumberArr.length, "생성된 defend number의 개수는 3개이다.");
		
		// digits length test
		for(int i=0; i<defendNumberArr.length; i++) {
			assertTrue(defendNumberArr[i]<=9 && defendNumberArr[i]>=1, "생성된 defend number의 개수는 3개이다.");
		}
		
	}
	
	@Test
	@DisplayName("game play test")
	void test_play() {
		int[] attackNumberArr = new int[3];
		int[] defendNumberArr = gamePlayer.startGame();
		
		// play game
		attackNumberArr[0] = defendNumberArr[0];
		attackNumberArr[1] = defendNumberArr[2];
		attackNumberArr[2] = defendNumberArr[1];
		
		PlayResultModel playReulst1 = gamePlayer.playGame(attackNumberArr);
		assertFalse(playReulst1.isFinish());
		assertEquals("스트라이크1개 볼2개", playReulst1.getResultMessage());
		
		attackNumberArr[0] = defendNumberArr[0];
		attackNumberArr[1] = defendNumberArr[1];
		attackNumberArr[2] = 0;
		
		PlayResultModel playReulst2 = gamePlayer.playGame(attackNumberArr);
		assertFalse(playReulst2.isFinish());
		assertEquals("스트라이크2개", playReulst2.getResultMessage());
		
		// 3Strkie, finish game
		PlayResultModel finishResult = gamePlayer.playGame(defendNumberArr);
		assertTrue(finishResult.isFinish());
		
	}
}
