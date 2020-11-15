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

	private Integer getStrikeCount(Set<BaseballNumber> computerNumbers, Set<BaseballNumber> userNumbers) {
		Set<BaseballNumber> compareSet = new HashSet<>(computerNumbers);
		compareSet.retainAll(userNumbers);
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
