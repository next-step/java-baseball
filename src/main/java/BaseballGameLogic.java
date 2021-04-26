import java.util.HashSet;
import java.util.Set;

public class BaseballGameLogic {
	private StringBuilder number;
	private StringBuilder previousNumber;
	private final int retryLimit = 5;
	private int retryCount = 0;

	public void makeNumber() {
		if (!isFirstTry()) {
			setPreviousNumber();
			setUnduplicateNumber();

			return;
		}

		setNumber();
	}

	private void setUnduplicateNumber() {
		while (previousNumber.equals(number) && retryCount < retryLimit) {
			setNumber();
			retryCount++;
		}

		retryCount = 0;
	}

	private boolean isFirstTry() {
		return previousNumber == null ? true : false;
	}

	private void setNumber() {
		int singleNumber;
		Set<Integer> usedNumbers = new HashSet<>();
		this.number = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			singleNumber = getUnduplicateSingleDigit(usedNumbers);

			number.append(singleNumber);
			usedNumbers.add(singleNumber);
		}
	}

	private void setPreviousNumber() {
		this.previousNumber = this.number;
	}

	private int getUnduplicateSingleDigit(Set<Integer> usedNumbers) {
		int candidateNumber = 0;

		while (candidateNumber <= 0 || candidateNumber >= 10 || usedNumbers.contains(candidateNumber)) {
			candidateNumber = (int) (Math.random() * 10);
		}

		return candidateNumber;
	}

	public String getNumber() {
		return this.number.toString();
	}

	public String getScore(String input) {
		int strikeCount = getStrikeCount(input);
		int ballCount = getBallCount(input);

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

	private int getBallCount(String input) {
		int ballCount = 0;

		for (int i = 0; i < 3; i++) {
			ballCount += getCount(number.charAt(i), input.charAt((i + 1) % 3));
			ballCount += getCount(number.charAt(i), input.charAt((i + 2) % 3));
		}

		return ballCount;
	}

	private int getStrikeCount(String input) {
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
