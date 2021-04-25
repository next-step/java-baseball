import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import number.Numbers;
import number.NumbersMatchResult;

class StrikeFirstResultRendererTest {

	@ParameterizedTest
	@CsvSource(value = {"123:123:3 스트라이크", "123:312:3볼", "123:456:낫싱", "134:431:1 스트라이크 2볼"}, delimiter = ':')
	@DisplayName("x 스트라이크, x볼, 낫싱, x 스트라이크 x볼 형태로 출력 되어야 한다.")
	public void strikeFirstRenderTest(String myNumbersInput, String yourNumbersInput, String expectedResultMessage) {
		// given
		Numbers myNumbers = Numbers.of(myNumbersInput);
		Numbers yourNumbers = Numbers.of(yourNumbersInput);
		StrikeFirstResultRenderer strikeFirstResultRenderer = new StrikeFirstResultRenderer();
		NumbersMatchResult numbersMatchResult = myNumbers.match(yourNumbers);

		// when
		String actualResultMessage = strikeFirstResultRenderer.render(numbersMatchResult);

		// then
		assertThat(actualResultMessage).isEqualTo(expectedResultMessage);
	}

}
