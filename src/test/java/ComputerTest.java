import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	Computer computer = new Computer();
	final int min = 1;
	final int max = 10;

	@Test
	void numberRandomResult() {
		int ran = computer.numberRandom(1, 100);
		System.out.println(ran);
		assertTrue(ran != 0);
	}

	@Test
	void numberMinResultTest() {
		for (int i = 0; i < 100; i++) {
			int ran = computer.numberRandom(min, max);
			System.out.println(ran);
			assertTrue(ran >= min);
		}
	}

	@Test
	void numberMaxResultTest() {
		for (int i = 0; i < 100; i++) {
			int ran = computer.numberRandom(min, max);
			System.out.println(ran);
			assertTrue(ran <= max);
		}
	}
}
