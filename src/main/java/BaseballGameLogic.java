import java.util.HashSet;
import java.util.Set;

public class BaseballGameLogic {
	private StringBuilder number;

	public void makeNumber() {
		setNumber();
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
