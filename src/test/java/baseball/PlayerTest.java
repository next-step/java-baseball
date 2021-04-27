package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

	@DisplayName("입력된 숫자를 추측 번호로 변환한다.")
	@ParameterizedTest
	@CsvSource(value = {
		"3:713:7,1,3",
		"3:123:1,2,3",
		"3:629:6,2,9"
	}, delimiter = ':')
	void guess(
		int numberLength,
		int input,
		@ConvertWith(IntArrayConverter.class) int[] expected
	) {
		Player player = new Player(numberLength);
		int[] actual = player.guess(input);

		assertArrayEquals(expected, actual);
	}

	@DisplayName("입력된 숫자를 게임 종료 코드로 변환한다.")
	@Test
	void exit() {
		int numberLength = 3;
		Player player = new Player(numberLength);

		assertEquals(GameExitCode.RESTART, player.exit(1));
		assertEquals(GameExitCode.EXIT, player.exit(2));
		assertEquals(GameExitCode.EXIT, player.exit(7));
	}
}