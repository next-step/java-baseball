import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	Computer computer = new Computer();

	@Test
	void initBallTest() {
		computer.setBallSet();
		assertEquals(computer.getBallSet().size(), computer.getMaxBallSize());
	}
}
