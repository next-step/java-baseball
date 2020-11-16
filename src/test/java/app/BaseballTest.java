package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

class BaseballTest {

	@Test
	@RepeatedTest(500)
	void createRandomGameNumberTest() {
		// given
		Baseball baseball = new Baseball();

		// when
		GameNumber randomGameNumber = baseball.createRandomGameNumber();

		// then
		assertThat(Integer.parseInt(randomGameNumber.toString()))
			.isBetween(123, 987);
		assertThat(new HashSet<>(randomGameNumber.getGameNumberList()).size())
			.isEqualTo(3);
	}
}
