import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRunnerRefereeTest {
	@Test
	@DisplayName("컴퓨터가 생성한 배열과 게임 플레이어가 입력한 배열을 비교하여 스트라이크 리턴")
	public void checkStrikeTest() {
		int[] playerInputNumbers = {1, 2, 3};
		int[] gameNumbers = {1, 4, 3};
		assertEquals(2, GameReferee.refereeStrike(playerInputNumbers, gameNumbers));
	}

	@Test
	@DisplayName("컴퓨터가 생성한 배열과 게임 플레이어가 입력한 배열을 비교하여 볼을 리턴")
	public void checkBallTest() {
		int[] playerInputNumbers = {1, 2, 3};
		int[] gameNumbers = {2, 4, 3};
		assertEquals(1, GameReferee.refereeBall(playerInputNumbers, gameNumbers));
	}
}