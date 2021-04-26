package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ComputerTest {
	@Test
	public void generateNumberTest() {
		int genNumber = Integer.parseInt(Computer.generateNumber());
		assertTrue(genNumber > 111 && genNumber < 999);

		/*
		 * 100의 자리수는 항상 참이므로 검증할 필요가 없으며 10의 자리수와 1의 자리수는 항상 한 자리 수이므로
		 * 0 이상인지에 대해서만 검증하면 된다
		 */
		int tensDigit = genNumber % 100 / 10;
		int unitDigit = genNumber % 100 % 10;
		assertTrue(tensDigit > 0);
		assertTrue(unitDigit > 0);
	}
}
