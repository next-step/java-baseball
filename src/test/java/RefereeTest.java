import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

	@DisplayName("스트라이크 판단")
	@Test
	void checkStrike() {
		final Integer computerNumber = 512;
		final Integer userNumber = 532;
		Integer strikeCount;

		Set<BaseballNumber> computerNumbers = convertIntegerToBaseballNumberSet(computerNumber);
		Set<BaseballNumber> userNumbers = convertIntegerToBaseballNumberSet(userNumber);

		strikeCount = this.getStrikeCount(computerNumbers, userNumbers);

		assertThat(strikeCount).isEqualTo(2);

	}

	@DisplayName("볼 판단")
	@Test
	void checkBall() {
		final Integer computerNumber = 425;
		final Integer userNumber = 456;
		Integer ballCount;

		Set<BaseballNumber> computerNumbers = convertIntegerToBaseballNumberSet(computerNumber);
		Set<BaseballNumber> userNumbers = convertIntegerToBaseballNumberSet(userNumber);

		ballCount = this.getBallCount(computerNumbers, userNumbers);

		assertThat(ballCount).isEqualTo(1);
	}

	@DisplayName("낫싱 판단")
	@Test
	void checkNothing() {
		final Integer computerNumber = 425;
		final Integer userNumber = 789;

		Set<BaseballNumber> computerNumbers = convertIntegerToBaseballNumberSet(computerNumber);
		Set<BaseballNumber> userNumbers = convertIntegerToBaseballNumberSet(userNumber);

		Integer strikeCount = this.getStrikeCount(computerNumbers, userNumbers);
		Integer ballCount = this.getBallCount(computerNumbers, userNumbers);

		boolean isNothing = strikeCount == 0 && ballCount == 0;

		assertThat(isNothing).isTrue();
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

	private Integer getStrikeCount(Set<BaseballNumber> computerNumbers, Set<BaseballNumber> userNumbers) {
		Set<BaseballNumber> compareSet = this.getRetainSetWith(computerNumbers, userNumbers);
		return compareSet.size();
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
