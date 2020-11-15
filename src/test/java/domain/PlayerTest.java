package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import domain.baseballRule.BaseballNumbers;

@Testable
public class PlayerTest {

	Player player = new Player();

	@DisplayName("Check input of player baseball numbers size between 0 to 2")
	@Test
	public void isExist() {
		List<Integer> inputs = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		BaseballNumbers playerBaseballNumbers = player.inputBaseballNumbers(inputs);
		assertTrue(playerBaseballNumbers.size() >= 0 && playerBaseballNumbers.size() <= 2);
	}

}
