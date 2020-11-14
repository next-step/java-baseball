import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

	@DisplayName("서로다른 수로 이루어진 3자리 난수 생성")
	@Test
	void generateRandomNumber_ShouldEqualToNumberCountAndTrueForLessThenOrEqualMaxInteger() {

		final int numberCount = 3;
		final int maxInteger = 9;
		final Set<Integer> numberSet = new LinkedHashSet<>(3);

		Random random = new Random();

		while (numberSet.size() < numberCount) {
			numberSet.add(Math.abs(random.nextInt(maxInteger - 1) + 1));
		}

		assertThat(numberSet.size()).isEqualTo(numberCount);
		for (Integer number : numberSet) {
			assertThat(number).isLessThanOrEqualTo(maxInteger);
		}

	}

}
