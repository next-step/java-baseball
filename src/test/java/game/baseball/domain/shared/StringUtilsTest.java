package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilsTest {

	@ParameterizedTest
	@CsvSource({"!,a,b,c,a!b!c", "/,a,b,c,a/b/c"})
	void joinTest(String delimiter, String inputString1, String inputString2, String inputString3,
		String expectedString) {
		assertThat(StringUtils.join(delimiter, inputString1, inputString2, inputString3))
			.isEqualTo(expectedString);
	}

}
