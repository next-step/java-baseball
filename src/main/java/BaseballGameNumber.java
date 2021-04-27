import java.util.HashSet;
import java.util.Set;

public class BaseballGameNumber {
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
}
