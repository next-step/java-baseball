package model;

public class BaseBallGameResult {

	private static final int ANSWER_COUNT = 3;

	private int strikeCount = 0;
	private int ballCount = 0;
	private RandomBallNumbers randomBallNumbers;
	private UserBallNumbers userBallNumbers;

	public BaseBallGameResult(RandomBallNumbers randomBallNumbers, UserBallNumbers userBallNumbers) {
		this.randomBallNumbers = randomBallNumbers;
		this.userBallNumbers = userBallNumbers;
		calculateResult();
	}

	private void calculateResult() {
		for (int i = 0; i < userBallNumbers.getUserBallNumbers().size(); i++) {
			calculateBallCount(i);
		}
	}

	private void calculateBallCount(int index) {
		int randomBallNumber = randomBallNumbers.getRandomBallNumbers().get(index);
		int userBallNumber = userBallNumbers.getUserBallNumbers().get(index);

		if (calculateStrikeCount(randomBallNumber, userBallNumber)) {
			return;
		}

		calculateBallCount(randomBallNumbers, userBallNumber);
	}

	private void calculateBallCount(RandomBallNumbers randomBallNumbers, int userBallNumber) {
		if (randomBallNumbers.getRandomBallNumbers().contains(userBallNumber)) {
			ballCount++;
		}
	}

	private boolean calculateStrikeCount(int randomBallNumber, int userBallNumber) {
		if (randomBallNumber == userBallNumber) {
			strikeCount++;
			return true;
		}

		return false;
	}

	public boolean isAnswer() {
		return strikeCount == ANSWER_COUNT;
	}

	public boolean isNothing() {
		return strikeCount == 0 && ballCount == 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

}
