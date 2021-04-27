package baseball.player;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 1:12 AM
 */

public class User {
	public int[] selectUserBalls(int ballCount, String number) {
		int[] balls = new int[ballCount];
		int ballLength = Math.min(number.length(), ballCount);
		for (int i = 0; i < ballLength; ++i) {
			balls[i] = number.charAt(i) - '0';
		}
		return balls;
	}
}
