import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRunnerTest {

	@Test
	@DisplayName("숫자 야구 게임을 위한 숫자 배열생성 확인")
	public void generateNumberBaseballGame() {
		int[] gameNumbers = GameRunner.generateNumberBaseballGame();

		/* 생성된 배열의 길이가 3인지 확인 */
		assertEquals(3, gameNumbers.length);

		Set<Integer> duplicateRemovedGameNumbers = new HashSet<>();
		for (int gameNumber : gameNumbers) {
			duplicateRemovedGameNumbers.add(gameNumber);
		}
		/* 숫자 배열의 중복여부 확인 */
		assertEquals(gameNumbers.length, duplicateRemovedGameNumbers.size());
	}

	@Test
	@DisplayName("플레이어가 입력한 숫자를 숫자 배열로 생성한다")
	public void playerInputNumbersToArrayTest() {
		int input = 543;
		int[] intArray = {5, 4, 3};
		assertArrayEquals(intArray, GameRunner.playerInputNumbersToArray(input));
	}
}