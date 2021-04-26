package game.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
		
		ArrayList<Integer> uniqueNumbers = new ArrayList<Integer>();
		for(int i=0; i<9; i++) {
			uniqueNumbers.add(i+1);
		}
		
		uniqueNumbers.remove(uniqueNumbers.indexOf(defendNumbers.getNumber(0)));
		uniqueNumbers.remove(uniqueNumbers.indexOf(defendNumbers.getNumber(1)));
		uniqueNumbers.remove(uniqueNumbers.indexOf(defendNumbers.getNumber(2)));
		
		// play game
		ThreeNumbers attackNumbers1 = new ThreeNumbers(
				defendNumbers.getNumber(0), defendNumbers.getNumber(2), defendNumbers.getNumber(1));
		
		assertEquals("스트라이크1개 볼2개", gamePlayer.playGame(attackNumbers1));
		assertFalse(gamePlayer.isFinish());
		
		
		ThreeNumbers attackNumbers2 = new ThreeNumbers(
				defendNumbers.getNumber(0), defendNumbers.getNumber(1), uniqueNumbers.get(0));
		
		assertEquals("스트라이크2개", gamePlayer.playGame(attackNumbers2));
		assertFalse(gamePlayer.isFinish());
		
		
		ThreeNumbers attackNumbers3 = new ThreeNumbers(
				uniqueNumbers.get(0), defendNumbers.getNumber(1), defendNumbers.getNumber(0));
		
		assertEquals("스트라이크1개 볼1개", gamePlayer.playGame(attackNumbers3));
		assertFalse(gamePlayer.isFinish());
		
		
		// 3Strkie, finish game
		assertEquals("스트라이크3개", gamePlayer.playGame(defendNumbers));
		assertTrue(gamePlayer.isFinish());
		
	}
}
