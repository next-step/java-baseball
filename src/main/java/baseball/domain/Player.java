package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private static final int BALL_SIZE = 3;

	private static final String ERROR_BALL_SIZE = "3개의 숫자를 입력해주세요.";
	private static final String ERROR_BALL_DUPLICATION = "중복된 숫자가 있습니다.";
	private static final String ERROR_BALL_RANGE = "1~9 까지의 숫자만 허용하고 있습니다.";

	private List<Integer> baseball;
	private int strikeCount = 0;
	private int ballCount = 0;

	public Player() {
	}

	public List<Integer> inputBaseBall(String playerInput) {
		baseball = new ArrayList<>();
		for(int i = 0; i < playerInput.length(); i++) {
			int ball = Character.getNumericValue(playerInput.charAt(i));
			validInput(ball);
			baseball.add(ball);
		}

		checkBallSize();
		resetCount();

		return baseball;
	}

	private void validInput(int input) {
		if(baseball.contains(input)) {
			throw new IllegalArgumentException(ERROR_BALL_DUPLICATION);
		}

		if(input < 1 ) {
			throw new IllegalArgumentException(ERROR_BALL_RANGE);
		}

	}

	private void checkBallSize() {
		if(baseball.size() != BALL_SIZE) {
			throw new IllegalArgumentException(ERROR_BALL_SIZE);
		}
	}

	public List<Integer> getBaseball() {
		return baseball;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setStrikeCount(int count) {
		strikeCount += count;
	}

	public void setBallCount(int count) {
		ballCount += count;
	}

	public void resetCount() {
		strikeCount = 0;
		ballCount = 0;
	}
}
