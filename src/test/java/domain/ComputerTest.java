package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ComputerTest {
	@Test
	public void generateNumberTest() {
		int genNumber = Integer.parseInt(Computer.generateNumber());
		assertThat(genNumber).isBetween(111, 999);

		int hundDigit = genNumber / 100;
		int tensDigit = genNumber % 100 / 10;
		int unitDigit = genNumber % 100 % 10;

		assertThat(hundDigit).isGreaterThan(0).isLessThan(10);
		assertThat(tensDigit).isGreaterThan(0).isLessThan(10);
		assertThat(unitDigit).isGreaterThan(0).isLessThan(10);
	}
}
