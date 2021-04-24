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
		for(int i = 0; i < 1000; i ++) {
			assertTrue(computer.getBall().length() < 4);
		}
	}

	@Test
	void resultTest() {

		String input = "123";
		Computer computer = new Computer();
		computer.setBallSet();
		if(computer.result(input) && computer.getStrikeCount() == 0 && computer.getBallCount() == 0) {
				System.out.println("낫싱");
		} else {
			System.out.println(computer.getStrikeCount() + "스트라이크" + computer.getBallCount() + "볼");
		}
		System.out.println("strike : " + computer.getStrikeCount());

	}
}
