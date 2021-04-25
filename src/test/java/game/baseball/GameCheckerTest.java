package game.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import common.models.HintModel;

public class GameCheckerTest {
	
	// mocking
	int[] defendNumberArr = {1,2,3};
	GameChecker gameChecker = new GameChecker();
	
	@Test
	void check_strike() {
		
		// 3-strike test
		HintModel resultHintModel1 = gameChecker.checker(new int[] {1,2,3}, defendNumberArr);
		assertEquals(3, resultHintModel1.getStrikeCount(), 
				"It should be 3-strike when defend digits equal input digits.");
		
		// 2-strike test
		HintModel resultHintModel2 = gameChecker.checker(new int[] {4,2,3}, defendNumberArr);
		assertEquals(2, resultHintModel2.getStrikeCount(), 
				"It should be 2-strike when defend digits contains 2 input digits in the same position.");
		
		// 1-strike test
		HintModel resultHintModel3 = gameChecker.checker(new int[] {4,5,3}, defendNumberArr);
		assertEquals(1, resultHintModel3.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		
		// 0-strike test
		HintModel resultHintModel4 = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, resultHintModel4.getStrikeCount(), 
				"It should be 0-strike when defend digits contains 0 input digits in the same position.");
	}
	
	@Test
	void check_ball() {
				
		// 3-ball test
		HintModel resultHintModel1 = gameChecker.checker(new int[] {3,1,2}, defendNumberArr);
		assertEquals(3, resultHintModel1.getBallCount(), 
				"It should be 3-ball when defend digits contains 3 input digits in the different position.");
		
		// 2-ball test
		HintModel resultHintModel2 = gameChecker.checker(new int[] {4,1,2}, defendNumberArr);
		assertEquals(2, resultHintModel2.getBallCount(), 
				"It should be 2-ball when defend digits contains 2 input digits in the different position.");
		
		// 1-ball test
		HintModel resultHintModel3 = gameChecker.checker(new int[] {4,5,2}, defendNumberArr);
		assertEquals(1, resultHintModel3.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
		// 0-ball test
		HintModel resultHintModel4 = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, resultHintModel4.getBallCount(), 
				"It should be 0-ball when defend digits contains 0 input digits in the different position.");
		
	}
	
	@Test
	void check_nothing() {
		// nothing test
		HintModel resultHintModel = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, resultHintModel.getBallCount()+resultHintModel.getBallCount(), 
				"It should be nothing when defend digits contains 0 input digits.");
	}
	
	@Test
	void check_strike_and_ball() {
		// 1-strike, 1-ball test
		HintModel resultHintModel = gameChecker.checker(new int[] {1,3,4}, defendNumberArr);
		assertEquals(1, resultHintModel.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		assertEquals(1, resultHintModel.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
	}
}
