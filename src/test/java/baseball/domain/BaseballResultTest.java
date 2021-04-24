package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballResult Test")
public class BaseballResultTest {

	@Test
	@DisplayName("init BaseballResult test")
	public void initBaseballResultTest() {
		BaseballResult baseballResult = new BaseballResult();
		assertTrue(baseballResult.getBallCount() == 0);
		assertTrue(baseballResult.getStrikeCount() == 0);
	}

	@Test
	@DisplayName("add strike BaseballResult test")
	public void addStrikeBaseballResultTest() {
		BaseballResult baseballResult = new BaseballResult();
		assertTrue(baseballResult.getBallCount() == 0);
		assertTrue(baseballResult.getStrikeCount() == 0);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 1);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 2);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 3);
	}

	@Test
	@DisplayName("add ball BaseballResult test")
	public void addBallBaseballResultTest() {
		BaseballResult baseballResult = new BaseballResult();
		assertTrue(baseballResult.getBallCount() == 0);
		assertTrue(baseballResult.getBallCount() == 0);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 1);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 2);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 3);
	}

	@Test
	@DisplayName("add ball and add strike BaseballResult test")
	public void addBallAndAddStrikeBaseballResultTest() {
		BaseballResult baseballResult = new BaseballResult();
		assertTrue(baseballResult.getBallCount() == 0);
		assertTrue(baseballResult.getBallCount() == 0);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 1);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 1);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 2);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 2);
		baseballResult.addBallCount();
		assertTrue(baseballResult.getBallCount() == 3);
		baseballResult.addStrikeCount();
		assertTrue(baseballResult.getStrikeCount() == 3);
	}
}
