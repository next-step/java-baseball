import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	Computer computer = new Computer();

	@Test
	void initBallTest() {
		computer.setBallSet();
		assertEquals(computer.getBall().length(), computer.getMaxBallSize());
	}

	@Test
	void setNumberLimitTest() {
		computer.setBallSet();
		for (int i = 0; i < 1000; i++) {
			assertTrue(computer.getBall().length() < 4);
		}
	}

	@Test
	void oneStrikeTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 0);
		computer.ballRuleCheck(oneBall.charAt(0), 0);

		//then
		assertEquals(1, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void twoStrikeTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 0);
		computer.ballRuleCheck(oneBall.charAt(0), 0);
		computer.strikeRuleCheck(twoBall.charAt(0), 1);
		computer.ballRuleCheck(twoBall.charAt(0), 1);

		//then
		assertEquals(2, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void threeStrikeTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);
		String threeBall = balls.substring(2, 3);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 0);
		computer.ballRuleCheck(oneBall.charAt(0), 0);
		computer.strikeRuleCheck(twoBall.charAt(0), 1);
		computer.ballRuleCheck(twoBall.charAt(0), 1);
		computer.strikeRuleCheck(threeBall.charAt(0), 2);
		computer.ballRuleCheck(threeBall.charAt(0), 2);

		//then
		assertEquals(3, computer.getStrikeCount());
		assertEquals(0, computer.getBallCount());
	}

	@Test
	void oneBallTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 1);
		computer.ballRuleCheck(oneBall.charAt(0), 1);

		//then
		assertEquals(0, computer.getStrikeCount());
		assertEquals(1, computer.getBallCount());
	}

	@Test
	void twoBallTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 1);
		computer.ballRuleCheck(oneBall.charAt(0), 1);
		computer.strikeRuleCheck(twoBall.charAt(0), 2);
		computer.ballRuleCheck(twoBall.charAt(0), 2);

		//then
		assertEquals(0, computer.getStrikeCount());
		assertEquals(2, computer.getBallCount());
	}

	@Test
	void threeBallTest() {
		//given
		Computer computer = new Computer();
		computer.setBallSet();
		String balls = computer.getBall();
		String oneBall = balls.substring(0, 1);
		String twoBall = balls.substring(1, 2);
		String threeBall = balls.substring(2, 3);

		//when
		computer.strikeRuleCheck(oneBall.charAt(0), 2);
		computer.ballRuleCheck(oneBall.charAt(0), 2);
		computer.strikeRuleCheck(twoBall.charAt(0), 0);
		computer.ballRuleCheck(twoBall.charAt(0), 0);
		computer.strikeRuleCheck(threeBall.charAt(0), 1);
		computer.ballRuleCheck(threeBall.charAt(0), 1);

		//then
		assertEquals(0, computer.getStrikeCount());
		assertEquals(3, computer.getBallCount());
	}
}
