package game.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import common.models.HintModel;
import common.models.ThreeNumbers;

public class GameCoreTest {
	
	GameCore gameCore = new GameCore();
	
	@Test
	void test_attack_check() {
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
		
		// 1-strike test
		HintModel strikeResult1= gameCore.checkAttack(1, 0, defendNumbers);
		assertEquals(1, strikeResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeResult2= gameCore.checkAttack(2, 1, defendNumbers);
		assertEquals(1, strikeResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeResult3= gameCore.checkAttack(3, 2, defendNumbers);
		assertEquals(1, strikeResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 1-ball test
		HintModel ballResult1= gameCore.checkAttack(1, 1, defendNumbers);
		assertEquals(0, ballResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel ballResult2= gameCore.checkAttack(2, 0, defendNumbers);
		assertEquals(0, ballResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel ballResult3= gameCore.checkAttack(3, 0, defendNumbers);
		assertEquals(0, ballResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(1, ballResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 0-strike, 0-ball test
		HintModel strikeBallResult1= gameCore.checkAttack(4, 0, defendNumbers);
		assertEquals(0, strikeBallResult1.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeBallResult2= gameCore.checkAttack(4, 1, defendNumbers);
		assertEquals(0, strikeBallResult2.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		HintModel strikeBallResult3= gameCore.checkAttack(4, 2, defendNumbers);
		assertEquals(0, strikeBallResult3.getStrikeCount(),"같은 위치, 같은 값일 경우 strike 이다.");
		assertEquals(0, strikeBallResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
	}
	
	@Test
	void test_strike() {
		
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
		
		// 3-strike test
//		HintModel strikeResult1 = gameCore.attack(new ThreeNumbers(123), defendNumbers);
//		assertEquals(3, strikeResult1.getStrikeCount(), 
//				"It should be 3-strike when defend digits equal input digits.");
		
		// 2-strike test
		HintModel strikeResult2 = gameCore.attack(new ThreeNumbers(423), defendNumbers);
		assertEquals(2, strikeResult2.getStrikeCount(), 
				"It should be 2-strike when defend digits contains 2 input digits in the same position.");
		
		// 1-strike test
		HintModel strikeResult3 = gameCore.attack(new ThreeNumbers(453), defendNumbers);
		assertEquals(1, strikeResult3.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		
		// 0-strike test
		HintModel strikeResult4 = gameCore.attack(new ThreeNumbers(456), defendNumbers);
		assertEquals(0, strikeResult4.getStrikeCount(), 
				"It should be 0-strike when defend digits contains 0 input digits in the same position.");
	}
	
	@Test
	void test_ball() {
		
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
				
		// 3-ball test
		HintModel ballResult1 = gameCore.attack(new ThreeNumbers(312), defendNumbers);
		assertEquals(3, ballResult1.getBallCount(), 
				"It should be 3-ball when defend digits contains 3 input digits in the different position.");
		
		// 2-ball test
		HintModel ballResult2 = gameCore.attack(new ThreeNumbers(412), defendNumbers);
		assertEquals(2, ballResult2.getBallCount(), 
				"It should be 2-ball when defend digits contains 2 input digits in the different position.");
		
		// 1-ball test
		HintModel ballResult3 = gameCore.attack(new ThreeNumbers(452), defendNumbers);
		assertEquals(1, ballResult3.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
		// 0-ball test
		HintModel ballResult4 = gameCore.attack(new ThreeNumbers(456), defendNumbers);
		assertEquals(0, ballResult4.getBallCount(), 
				"It should be 0-ball when defend digits contains 0 input digits in the different position.");
		
	}
	
	@Test
	void test_nothing() {
		// nothing test
		HintModel nothingResult = gameCore.attack(new ThreeNumbers(456), new ThreeNumbers(123));
		assertEquals(0, nothingResult.getBallCount()+nothingResult.getBallCount(), 
				"It should be nothing when defend digits contains 0 input digits.");
	}
	
	@Test
	void test_strike_and_ball() {
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
		
		// 1-strike, 1-ball test
		HintModel strikeBallResult = gameCore.attack(new ThreeNumbers(134), defendNumbers);
		assertEquals(1, strikeBallResult.getStrikeCount(), 
				"It should be 1-strike when defend digits contains 1 input digits in the same position.");
		assertEquals(1, strikeBallResult.getBallCount(), 
				"It should be 1-ball when defend digits contains 1 input digits in the different position.");
		
	}
	
	@Test
	void test_make_defend_number_array() {
		// range test & length test
		ThreeNumbers defendNumbers = gameCore.makeDefendNumber();
		assertTrue(defendNumbers.getNumber(0)>0 && defendNumbers.getNumber(0)<10, "");
		assertTrue(defendNumbers.getNumber(1)>0 && defendNumbers.getNumber(1)<10, "");
		assertTrue(defendNumbers.getNumber(2)>0 && defendNumbers.getNumber(2)<10, "");
		assertThrows(Exception.class, ()->{
			defendNumbers.getNumber(3);
		}, "defend number 개수는 3개여야한다.");
		
		// unique test
		int first = defendNumbers.getNumber(0);
		assertTrue(first != defendNumbers.getNumber(1),"");
		assertTrue(first != defendNumbers.getNumber(2),"");
		
		int second = defendNumbers.getNumber(1);
		assertTrue(second != defendNumbers.getNumber(0),"");
		assertTrue(second != defendNumbers.getNumber(2),"");
		
		int third = defendNumbers.getNumber(2);
		assertTrue(third != defendNumbers.getNumber(0),"");
		assertTrue(third != defendNumbers.getNumber(1),"");
		
	}
	
}
