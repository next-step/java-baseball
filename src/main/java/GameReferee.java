/**
 * 숫자 야구 게임의 스트라이크 볼을 판단하는 클래스
 */
public class GameReferee {

	public static int refereeStrike(int[] playerInputNumbers, int[] gameNumbers) {
		int strike = 0;
		for (int i = 0; i < playerInputNumbers.length; i++) {
			if (playerInputNumbers[i] == gameNumbers[i]) {
				strike++;
			}
		}
		return strike;
	}

	public static int refereeBall(int[] playerInputNumbers, int[] gameNumbers) {
		int ball = 0;
		for (int i = 0; i < playerInputNumbers.length; i++) {
			for (int j = 0; j < gameNumbers.length; j++) {
				if (playerInputNumbers[i] == gameNumbers[j] && i != j) {
					ball++;
				}
			}
		}
		return ball;
	}
}
