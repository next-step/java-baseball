package utils;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilsTest {

	@DisplayName("범위 내 난수 생성")
	@Test
	public void testPickRandomNumbers() {
		//given
		int maxAmount = 9;
		int pickNumber = 3;

		//when
		List<Integer> randomNumbers = RandomUtils.pickRandomInSerialNumbers(maxAmount, pickNumber);

		//then
		assertThat(randomNumbers.size()).isEqualTo(pickNumber);
		assertThat(randomNumbers.size()).isEqualTo(new HashSet<>(randomNumbers).size());
	}
}
