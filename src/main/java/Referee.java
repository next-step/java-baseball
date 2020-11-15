import java.util.HashSet;
import java.util.Set;

public class Referee {

	public BaseballResult discriminate(Integer computerNumber, Integer userNumber) {

		Set<BaseballNumber> computerNumbers = convertIntegerToBaseballNumberSet(computerNumber);
		Set<BaseballNumber> userNumbers = convertIntegerToBaseballNumberSet(userNumber);

		Integer strikeCount = this.getStrikeCount(computerNumbers, userNumbers);
		Integer ballCount = this.getBallCount(computerNumbers, userNumbers);

		return new BaseballResult(strikeCount, ballCount);

	}

	private Integer getStrikeCount(Set<BaseballNumber> computerNumbers, Set<BaseballNumber> userNumbers) {
		Set<BaseballNumber> compareSet = this.getRetainSetWith(computerNumbers, userNumbers);
		return compareSet.size();
	}

	private Integer getBallCount(Set<BaseballNumber> computerNumbers, Set<BaseballNumber> userNumbers) {
		Set<BaseballNumber> retainSet = this.getRetainSetWith(computerNumbers, userNumbers);
		Set<BaseballNumber> remainComputerNumbers = new HashSet<>(computerNumbers);
		Set<BaseballNumber> remainUserNumbers = new HashSet<>(userNumbers);
		remainComputerNumbers.removeAll(retainSet);
		remainUserNumbers.removeAll(retainSet);

		Set<Integer> computerIntegerNumbers = this.convertToIntegerSet(remainComputerNumbers);
		Set<Integer> userIntegerNumbers = this.convertToIntegerSet(remainUserNumbers);

		computerIntegerNumbers.retainAll(userIntegerNumbers);

		return computerIntegerNumbers.size();
	}

	private Set<Integer> convertToIntegerSet(Set<BaseballNumber> remainBaseballNumberSet) {
		Set<Integer> integerSet = new HashSet<>();
		for (BaseballNumber baseballNumber : remainBaseballNumberSet) {
			integerSet.add(baseballNumber.getValue());
		}
		return integerSet;
	}

	private Set<BaseballNumber> getRetainSetWith(Set<BaseballNumber> computerNumbers, Set<BaseballNumber> userNumbers) {
		Set<BaseballNumber> compareSet = new HashSet<>(computerNumbers);
		compareSet.retainAll(userNumbers);
		return compareSet;
	}

	private Set<BaseballNumber> convertIntegerToBaseballNumberSet(Integer number) {
		String[] numberArray = number.toString().split("");
		Set<BaseballNumber> numbers = new HashSet<>(numberArray.length);
		for (int index = 0; index < numberArray.length; index++) {
			numbers.add(new BaseballNumber(Integer.parseInt(numberArray[index]), index));
		}
		return numbers;
	}

}
