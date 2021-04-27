import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallGameTest {

	@Test
	@DisplayName("숫자 야구 게임을 위한 숫자 배열생성 확인")
	public void generateNumberBaseballGame() {
		int[] gameNumbers = NumberBaseBallGame.generateNumberBaseballGame();

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
	@DisplayName("플레이어가 입력한 숫자 배열의 길이를 확인한다")
	public void validatePlayerNumbersLengthTest() {
		int[] playerInputNumbers = {1, 2, 3};
		assertEquals(true, NumberBaseBallGame.validatePlayerNumbersLength(playerInputNumbers));
	}

	@Test
	@DisplayName("플레이어가 입력한 숫자 배열의 중복을 확인한다")
	public void validatePlayerNumbersDuplicate() {
		int[] playerInputNumbers = {1, 2, 3};
		assertEquals(true, NumberBaseBallGame.validatePlayerNumbersLength(playerInputNumbers));
	}

	@Test
	@DisplayName("플레이어가 입력한 숫자를 숫자 배열로 생성한다")
	public void playerInputNumbersToArrayTest() {
		int input = 543;
		int[] intArray = {5, 4, 3};
		assertArrayEquals(intArray, NumberBaseBallGame.playerInputNumbersToArray(input));
	}

	@Test
	@DisplayName("컴퓨터가 생성한 배열과 게임 플레이어가 입력한 배열을 비교하여 스트라이크 리턴")
	public void checkStrikeTest() {
		int[] playerInputNumbers = {1, 2, 3};
		int[] gameNumbers = {1, 4, 3};
		assertEquals(2, NumberBaseBallGame.checkStrike(playerInputNumbers, gameNumbers));
	}

	@Test
	@DisplayName("컴퓨터가 생성한 배열과 게임 플레이어가 입력한 배열을 비교하여 볼을 리턴")
	public void checkBallTest() {
		int[] playerInputNumbers = {1, 2, 3};
		int[] gameNumbers = {2, 4, 3};
		assertEquals(1, NumberBaseBallGame.checkBall(playerInputNumbers, gameNumbers));
	}
}