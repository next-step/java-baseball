package game.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import common.models.HintModel;

public class GameCoreTest {
	
	// mocking
	int[] defendNumberArr = {1,2,3};
	GameCore gameChecker = new GameCore();
	
	@Test
	void attack_test() {
		// 1-strike test
		HintModel strikeResult1= gameChecker.attack(1, 0, new int[] {1,2,3});
		assertEquals(1, strikeResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeResult2= gameChecker.attack(2, 1, new int[] {1,2,3});
		assertEquals(1, strikeResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeResult3= gameChecker.attack(3, 2, new int[] {1,2,3});
		assertEquals(1, strikeResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 1-ball test
		HintModel ballResult1= gameChecker.attack(1, 1, new int[] {1,2,3});
		assertEquals(0, ballResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel ballResult2= gameChecker.attack(2, 0, new int[] {1,2,3});
		assertEquals(0, ballResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel ballResult3= gameChecker.attack(3, 0, new int[] {1,2,3});
		assertEquals(0, ballResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 0-strike, 0-ball test
		HintModel strikeBallResult1= gameChecker.attack(4, 0, new int[] {1,2,3});
		assertEquals(0, strikeBallResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeBallResult2= gameChecker.attack(4, 1, new int[] {1,2,3});
		assertEquals(0, strikeBallResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeBallResult3= gameChecker.attack(4, 2, new int[] {1,2,3});
		assertEquals(0, strikeBallResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
	}
	
	@Test
	void check_strike() {
		
		// 3-strike test
		HintModel strikeResult1 = gameChecker.checker(new int[] {1,2,3}, defendNumberArr);
		assertEquals(3, strikeResult1.getStrikeCount(), 
				"It should be 3-strike when defend digits equal input digits.");
		
		// 2-strike test
		HintModel strikeResult2 = gameChecker.checker(new int[] {4,2,3}, defendNumberArr);
		assertEquals(2, strikeResult2.getStrikeCount(), 
				"It should be 2-strike when defend digits contains 2 input digits in the same position.");
		
		// 1-strike test
		HintModel strikeResult3 = gameChecker.checker(new int[] {4,5,3}, defendNumberArr);
		assertEquals(1, strikeResult3.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		
		// 0-strike test
		HintModel strikeResult4 = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, strikeResult4.getStrikeCount(), 
				"It should be 0-strike when defend digits contains 0 input digits in the same position.");
	}
	
	@Test
	void check_ball() {
				
		// 3-ball test
		HintModel ballResult1 = gameChecker.checker(new int[] {3,1,2}, defendNumberArr);
		assertEquals(3, ballResult1.getBallCount(), 
				"It should be 3-ball when defend digits contains 3 input digits in the different position.");
		
		// 2-ball test
		HintModel ballResult2 = gameChecker.checker(new int[] {4,1,2}, defendNumberArr);
		assertEquals(2, ballResult2.getBallCount(), 
				"It should be 2-ball when defend digits contains 2 input digits in the different position.");
		
		// 1-ball test
		HintModel ballResult3 = gameChecker.checker(new int[] {4,5,2}, defendNumberArr);
		assertEquals(1, ballResult3.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
		// 0-ball test
		HintModel ballResult4 = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, ballResult4.getBallCount(), 
				"It should be 0-ball when defend digits contains 0 input digits in the different position.");
		
	}
	
	@Test
	void check_nothing() {
		// nothing test
		HintModel nothingResult = gameChecker.checker(new int[] {4,5,6}, defendNumberArr);
		assertEquals(0, nothingResult.getBallCount()+nothingResult.getBallCount(), 
				"It should be nothing when defend digits contains 0 input digits.");
	}
	
	@Test
	void check_strike_and_ball() {
		// 1-strike, 1-ball test
		HintModel strikeBallResult = gameChecker.checker(new int[] {1,3,4}, defendNumberArr);
		assertEquals(1, strikeBallResult.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		assertEquals(1, strikeBallResult.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
	}
	
}
