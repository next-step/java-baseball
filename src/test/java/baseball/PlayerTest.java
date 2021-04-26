package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

	@ParameterizedTest
	@CsvSource(value = {
		"713:7,1,3",
		"123:1,2,3",
		"629:6,2,9"
	}, delimiter = ':')
	void guess(
		int input,
		@ConvertWith(IntArrayConverter.class) int[] expected
	) {
		int numberLength = 3;
		Player player = new Player(numberLength);
		int[] actual = player.guess(input);

		assertArrayEquals(expected, actual);
	}

	@Test
	void proceed() {
		int numberLength = 3;
		Player player = new Player(numberLength);

		assertEquals(ProceedType.RESTART, player.proceed(1));
		assertEquals(ProceedType.EXIT, player.proceed(2));
		assertEquals(ProceedType.EXIT, player.proceed(7));
	}

}