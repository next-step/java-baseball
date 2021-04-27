package game.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import common.models.HintModel;
import common.models.ThreeNumbers;

public class GameCoreTest {
	
	GameCore gameCore = new GameCore();
	
	@Test
	@DisplayName("strike or ball check test")
	void attackTest_ShouldBeStrikeOrBallOrZero() {
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
	@DisplayName("only strike test")
	void strikeTest_checkNumberOfStrike() {
		
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
		
		// 3-strike test
		HintModel strikeResult1 = gameCore.attack(new ThreeNumbers(123), defendNumbers);
		assertEquals(3, strikeResult1.getStrikeCount(), "같은 위치, 같은 값일 경우 strike 이다.");
		
		// 2-strike test
		HintModel strikeResult2 = gameCore.attack(new ThreeNumbers(423), defendNumbers);
		assertEquals(2, strikeResult2.getStrikeCount(), "같은 위치, 같은 값일 경우 strike 이다.");
		
		// 1-strike test
		HintModel strikeResult3 = gameCore.attack(new ThreeNumbers(453), defendNumbers);
		assertEquals(1, strikeResult3.getStrikeCount(), "같은 위치, 같은 값일 경우 strike 이다.");
		
		// 0-strike test
		HintModel strikeResult4 = gameCore.attack(new ThreeNumbers(456), defendNumbers);
		assertEquals(0, strikeResult4.getStrikeCount(), "같은 위치, 같은 값일 경우 strike 이다.");
	}
	
	@Test
	@DisplayName("ball test")
	void ballTest_checkNumberOfBall() {
		
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
				
		// 3-ball test
		HintModel ballResult1 = gameCore.attack(new ThreeNumbers(312), defendNumbers);
		assertEquals(3, ballResult1.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");;
		
		// 2-ball test
		HintModel ballResult2 = gameCore.attack(new ThreeNumbers(412), defendNumbers);
		assertEquals(2, ballResult2.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 1-ball test
		HintModel ballResult3 = gameCore.attack(new ThreeNumbers(452), defendNumbers);
		assertEquals(1, ballResult3.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
		// 0-ball test
		HintModel ballResult4 = gameCore.attack(new ThreeNumbers(456), defendNumbers);
		assertEquals(0, ballResult4.getBallCount(),"다른 위치, 같은 값일 경우 ball 이다.");
		
	}
	
	@Test
	@DisplayName("nothing test")
	void nothingTest_shouldBeNothing() {
		// nothing test
		HintModel nothingResult = gameCore.attack(new ThreeNumbers(456), new ThreeNumbers(123));
		assertEquals(0, nothingResult.getBallCount()+nothingResult.getBallCount(),
				"포함되는 숫자가 전혀 없을 경우 nothing 이다.");
	}
	
	@Test
	@DisplayName("all mixed hints test")
	void strikeAndBallTest_checkNumberOfstrikeAndBall() {
		ThreeNumbers defendNumbers = new ThreeNumbers(123);
		
		// 1-strike, 1-ball test
		HintModel strikeBallResult = gameCore.attack(new ThreeNumbers(134), defendNumbers);
		assertEquals(1, strikeBallResult.getStrikeCount(), 
				"1은 같은 포지션에 같은 값으로 1-strike이다.");
		assertEquals(1, strikeBallResult.getBallCount(), 
				"3은 다른 포지션에 같은 값으로 1-ball이다.");
		
		// 1-strike, 2-ball test
		HintModel strikeBallResult2 = gameCore.attack(new ThreeNumbers(132), defendNumbers);
		assertEquals(1, strikeBallResult2.getStrikeCount(), 
				"1은 같은 포지션에 같은 값으로 1-strike이다.");
		assertEquals(2, strikeBallResult2.getBallCount(), 
				"3,2은 다른 포지션에 같은 값으로 1-ball이다.");
	}
	
	@Test
	@DisplayName("making defend number test")
	void makeDefendNumbersTest_checkIsValidDefendNumbers() {
		// range test & length test
		ThreeNumbers defendNumbers = gameCore.makeDefendNumbers();
		assertTrue(defendNumbers.getNumber(0)>0 && defendNumbers.getNumber(0)<10, "");
		assertTrue(defendNumbers.getNumber(1)>0 && defendNumbers.getNumber(1)<10, "");
		assertTrue(defendNumbers.getNumber(2)>0 && defendNumbers.getNumber(2)<10, "");
		
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
