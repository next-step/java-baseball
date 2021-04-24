package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import baseball.domain.BallNumber;
import baseball.domain.BaseballResult;

@DisplayName("BaseballRule Test")
public class BaseballRuleTest {

	@RepeatedTest(10)
	@DisplayName("getResult BaseballRule test")
	public void getResultBaseballRuleTest() {
		BallNumber playerBallNumber = new BallNumber();
		BallNumber computerBallNumber = new BallNumber();
		System.out.println("Player Ball Number : " + playerBallNumber.toString());
		System.out.println("Computer Ball Number : " + computerBallNumber.toString());
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		System.out.println("Ball Count : " + baseballResult.getBallCount());
		System.out.println("Strike Count : " + baseballResult.getStrikeCount());
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
	}

	@Test
	@DisplayName("getResult BaseballRule Three Strike test")
	public void getResultBaseballRuleThreeStrikeTest() {
		BallNumber playerBallNumber = new BallNumber(123);
		BallNumber computerBallNumber = new BallNumber(123);
		System.out.println("Player Ball Number : " + playerBallNumber.toString());
		System.out.println("Computer Ball Number : " + computerBallNumber.toString());
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		System.out.println("Ball Count : " + baseballResult.getBallCount());
		System.out.println("Strike Count : " + baseballResult.getStrikeCount());
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 3);
		assertTrue(baseballResult.getBallCount() == 0);
	}

	@Test
	@DisplayName("getResult BaseballRule Three Ball test")
	public void getResultBaseballRuleThreeBallTest() {
		BallNumber playerBallNumber = new BallNumber(123);
		BallNumber computerBallNumber = new BallNumber(312);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 0);
		assertTrue(baseballResult.getBallCount() == 3);
	}

	@Test
	@DisplayName("getResult BaseballRule One Strike One Ball test")
	public void getResultBaseballRuleOneStrikeOneBallTest() {
		BallNumber playerBallNumber = new BallNumber(123);
		BallNumber computerBallNumber = new BallNumber(135);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 1);
		assertTrue(baseballResult.getBallCount() == 1);
	}

	@Test
	@DisplayName("getResult BaseballRule Two Strike test")
	public void getResultBaseballRuleTwoStrikeTest() {
		BallNumber playerBallNumber = new BallNumber(123);
		BallNumber computerBallNumber = new BallNumber(125);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 2);
		assertTrue(baseballResult.getBallCount() == 0);
	}


	@Test
	@DisplayName("getResult BaseballRule One Strike Two Ball test")
	public void getResultBaseballRuleOneStrikeTwoBallTest() {
		BallNumber playerBallNumber = new BallNumber(132);
		BallNumber computerBallNumber = new BallNumber(123);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 1);
		assertTrue(baseballResult.getBallCount() == 2);
	}

	@Test
	@DisplayName("getResult BaseballRule Two Ball test")
	public void getResultBaseballRuleTwoBallTest() {
		BallNumber playerBallNumber = new BallNumber(132);
		BallNumber computerBallNumber = new BallNumber(523);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 0);
		assertTrue(baseballResult.getBallCount() == 2);
	}

	@Test
	@DisplayName("getResult BaseballRule One Strike test")
	public void getResultBaseballRuleOneStrikeTest() {
		BallNumber playerBallNumber = new BallNumber(567);
		BallNumber computerBallNumber = new BallNumber(523);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 1);
		assertTrue(baseballResult.getBallCount() == 0);
	}

	@Test
	@DisplayName("getResult BaseballRule One Ball test")
	public void getResultBaseballRuleOneBallTest() {
		BallNumber playerBallNumber = new BallNumber(367);
		BallNumber computerBallNumber = new BallNumber(523);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 0);
		assertTrue(baseballResult.getBallCount() == 1);
	}

	@Test
	@DisplayName("getResult BaseballRule Nothing test")
	public void getResultBaseballRuleNothingTest() {
		BallNumber playerBallNumber = new BallNumber(123);
		BallNumber computerBallNumber = new BallNumber(456);
		BaseballRule baseballRule = new BaseballRule(playerBallNumber, computerBallNumber);
		BaseballResult baseballResult = baseballRule.getResult();
		assertTrue(baseballResult.getStrikeCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() < BallNumber.MAX_SIZE + 1);
		assertTrue(baseballResult.getBallCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() > BallNumber.MIN_SIZE - 1);
		assertTrue(baseballResult.getStrikeCount() == 0);
		assertTrue(baseballResult.getBallCount() == 0);
	}
}
