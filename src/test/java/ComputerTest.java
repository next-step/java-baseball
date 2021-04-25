import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

	Computer computer;

	@BeforeEach
	void reset() {
		computer = new Computer();
		computer.setBallSet();
	}

	@Test
	void setBallTest() {
		assertEquals(computer.getBall().length(), Computer.MAX_BALL_SIZE);
	}

	@Test
	void setNumberLimitTest() {
		for (int i = 0; i < 1000; i++) {
			assertTrue(computer.getBall().length() < 4);
		}
	}

	@Test
	void checkOneStrikeTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 0);
		computer.checkRuleBall(oneBall.charAt(0), 0);

		/* then */
		assertEquals(1, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void checkTwoStrikeTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 0);
		computer.checkRuleBall(oneBall.charAt(0), 0);
		computer.checkRuleStrike(twoBall.charAt(0), 1);
		computer.checkRuleBall(twoBall.charAt(0), 1);

		/* then */
		assertEquals(2, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void checkThreeStrikeTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);
		String threeBall = balls.substring(2, 3);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 0);
		computer.checkRuleBall(oneBall.charAt(0), 0);
		computer.checkRuleStrike(twoBall.charAt(0), 1);
		computer.checkRuleBall(twoBall.charAt(0), 1);
		computer.checkRuleStrike(threeBall.charAt(0), 2);
		computer.checkRuleBall(threeBall.charAt(0), 2);

		/* then */
		assertEquals(3, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void checkOneBallTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 1);
		computer.checkRuleBall(oneBall.charAt(0), 1);

		/* then */
		assertEquals(0, computer.getStrikeCount());
		assertEquals(1, computer.getBallCount());
	}

	@Test
	void checkTwoBallTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 1);
		computer.checkRuleBall(oneBall.charAt(0), 1);
		computer.checkRuleStrike(twoBall.charAt(0), 0);
		computer.checkRuleBall(twoBall.charAt(0), 0);

		/* then */
		assertEquals(0, computer.getStrikeCount());
		assertEquals(2, computer.getBallCount());
	}

	@Test
	void checkThreeBallTest() {
		/* given */
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);
		String threeBall = balls.substring(2, 3);

		/* when */
		computer.checkRuleStrike(oneBall.charAt(0), 2);
		computer.checkRuleBall(oneBall.charAt(0), 2);
		computer.checkRuleStrike(twoBall.charAt(0), 0);
		computer.checkRuleBall(twoBall.charAt(0), 0);
		computer.checkRuleStrike(threeBall.charAt(0), 1);
		computer.checkRuleBall(threeBall.charAt(0), 1);

		/* then */
		assertEquals(0, computer.getStrikeCount());
		assertEquals(3, computer.getBallCount());
	}
}
