import java.util.ArrayList;
import java.util.List;

public class UserInputConverter {
	private final String textBalls;

	public UserInputConverter(String textBalls) {
		this.textBalls = textBalls;
	}

	public List<Integer> convertBallsItem() {
		List<Integer> ballsItem = new ArrayList<>();

		int length = textBalls.length();
		for (int i = 0 ; i < length ; i++) {
			char textBall = textBalls.charAt(i);
			int ball = Character.digit(textBall, 10);
			ballsItem.add(ball);
		}

		return ballsItem;
	}
}
