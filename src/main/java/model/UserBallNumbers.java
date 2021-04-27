package model;

import java.util.List;

public class UserBallNumbers {

	public static final int USER_BALL_MIN_NUMBER = 1;
	public static final int USER_BALL_MAX_NUMBER = 9;
	public static final int USER_BALL_NUMBER_SIZE = 3;

	private final List<Integer> userBallNumbers;

	public UserBallNumbers(List<Integer> userBallNumbers) {
		validateUserBallNumbers(userBallNumbers);
		this.userBallNumbers = userBallNumbers;
	}

	private void validateUserBallNumbers(List<Integer> userBallNumbers) {
		validateSize(userBallNumbers);

		for (int userBallNumber : userBallNumbers) {
			validateRange(userBallNumber);
		}
	}

	private void validateSize(List<Integer> userBallNumbers) {
		if (userBallNumbers.size() != USER_BALL_NUMBER_SIZE) {
			throw new IllegalArgumentException("입력한 수가 3자리 수가 아닙니다");
		}
	}

	private void validateRange(int userBallNumber) {
		if (userBallNumber < USER_BALL_MIN_NUMBER || userBallNumber > USER_BALL_MAX_NUMBER) {
			throw new IllegalArgumentException("입력한 수가 1부터 9까지 정수가 아닙니다");
		}
	}

	public List<Integer> getUserBallNumbers() {
		return userBallNumbers;
	}
}
