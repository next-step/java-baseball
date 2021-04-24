package baseball.service;

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

	}
}
