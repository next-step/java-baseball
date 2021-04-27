import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballCalculatorTest {
	@DisplayName("Get randomly generated answer with non-duplicate numbers successfully")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9})
	void getRandomAnswerTest(int maxDigit) {
		String result = BaseballCalculator.getRandomAnswer(maxDigit);
		assertThat(result.length()).isEqualTo(maxDigit);
		assertThat(result).containsOnlyDigits();
		assertThat(result).doesNotContain("0");
		
		Set<String> set = new HashSet<>();
		Collections.addAll(set, result.split(""));
		assertThat(set.size()).isEqualTo(maxDigit);
	}
}
