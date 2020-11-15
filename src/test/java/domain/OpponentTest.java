package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class OpponentTest {

	Opponent opponent = new Opponent();

	@DisplayName("Opponent generated baseball numbers length is 3")
	@Test
	public void isLength3() {
		BaseballNumbers opponentBaseballNumbers = opponent.generateBaseballNumbers();
		assertEquals(3, opponentBaseballNumbers.size());

	}

	@DisplayName("Repeat 100 times for random generated opponent baseball numbers is each unique")
	@RepeatedTest(100)
	public void isUnique() {
		BaseballNumbers opponentBaseballNumbers = opponent.generateBaseballNumbers();
		assertNotEquals(opponentBaseballNumbers.getByIndex(0), opponentBaseballNumbers.getByIndex(1));
		assertNotEquals(opponentBaseballNumbers.getByIndex(0), opponentBaseballNumbers.getByIndex(2));
		assertNotEquals(opponentBaseballNumbers.getByIndex(1), opponentBaseballNumbers.getByIndex(2));
	}

}
