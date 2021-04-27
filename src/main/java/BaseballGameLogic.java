public class BaseballGameLogic {
	public String getScore(String baseballGameNumber, String guessNumber) {
		int strikeCount = getStrikeCount(baseballGameNumber, guessNumber);
		int ballCount = getBallCount(baseballGameNumber, guessNumber);

		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}

		return getResultScore(strikeCount, ballCount);
	}

	private String getResultScore(int strikeCount, int ballCount) {
		StringBuilder result = new StringBuilder();

		if (strikeCount > 0) {
			result.append(strikeCount + " 스트라이크 ");
		}

		if (ballCount > 0) {
			result.append(ballCount + " 볼");
		}

		return result.toString();
	}

	private int getBallCount(String number, String input) {
		int ballCount = 0;

		for (int i = 0; i < 3; i++) {
			ballCount += getCount(number.charAt(i), input.charAt((i + 1) % 3));
			ballCount += getCount(number.charAt(i), input.charAt((i + 2) % 3));
		}

		return ballCount;
	}

	private int getStrikeCount(String number, String input) {
		int strikeCount = 0;

		for (int i = 0; i < 3; i++) {
			strikeCount += getCount(number.charAt(i), input.charAt(i));
		}

		return strikeCount;
	}

	private int getCount(int value1, int value2) {
		if (value1 == value2) {
			return 1;
		}

		return 0;
	}
}
