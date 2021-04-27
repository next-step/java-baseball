package game.baseball;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import common.models.ThreeNumbers;

public class GamePlayerTest {
	
	GamePlayer gamePlayer = new GamePlayer();
	
	@Test
	@DisplayName("game start test")
	void startTest_shouldInitIsFinishAndDefendNumbers() {
		ThreeNumbers defendNumbers = gamePlayer.startGame();
		assertNotNull(defendNumbers, "생성된 defend number은 null이어서는 안된다.");
		assertEquals(gamePlayer.isFinish(), false, "startGame은 isFinish를 false로 초기화한다.");
		//defendNumbers에 대한 테스트는 GameCoreTest.makeDefendNumbersTest_checkValidDefendNumbers 참조
	}
	
	@Test
	@DisplayName("game play test")
	void palyGameTest_checkReturnHintModel() {
		
		ThreeNumbers defendNumbers = gamePlayer.startGame();
		
		//defendNumbers에 포함되지 않는 uniqueNumber를 얻기 위한 arrayList
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
		
		ThreeNumbers attackNumbers4 = new ThreeNumbers(
				defendNumbers.getNumber(0), uniqueNumbers.get(1), uniqueNumbers.get(2));
		assertEquals("스트라이크1개", gamePlayer.playGame(attackNumbers4));
		assertFalse(gamePlayer.isFinish());
		
		ThreeNumbers attackNumbers5 = new ThreeNumbers(
				uniqueNumbers.get(0), uniqueNumbers.get(1), uniqueNumbers.get(2));
		assertEquals("낫싱", gamePlayer.playGame(attackNumbers5));
		assertFalse(gamePlayer.isFinish());
		
		// 3-strike, finish game
		assertEquals("스트라이크3개", gamePlayer.playGame(defendNumbers));
		assertTrue(gamePlayer.isFinish());
		
	}
}
