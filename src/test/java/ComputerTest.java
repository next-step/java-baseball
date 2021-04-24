import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	@Test
	void initBallTest() {
		Computer computer = new Computer();
		computer.setBallSet();
		assertEquals(computer.getBall().length(), computer.getMaxBallSize());
	}

	@Test
	void getMaxBallSize() {
		Computer computer = new Computer();
		assertTrue(computer.getMaxBallSize() > 0);
	}

	@Test
	void setBallSet() {
		Computer computer = new Computer();
		computer.setBallSet();
		assertTrue(computer.getBall().length() > 0);
	}

	@Test
	void resultTest() {

		String input = "123";
		Computer computer = new Computer();
		computer.setBallSet();
		boolean result = computer.result(input);

		assertEquals(result, (computer.getStrikeCount() == computer.getMaxBallSize()));
	}
}
