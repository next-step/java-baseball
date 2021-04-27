import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import number.HintsCount;
import number.Numbers;

class StrikeCountGameOverJudgeTest {

	@ParameterizedTest
	@CsvSource(value = {"123:123:true", "123:124:false"}, delimiter = ':')
	@DisplayName("세 숫자가 모두 일치해야 한 턴 종료이다.")
	public void isGameOverTest(String myNumbersInput, String yourNumbersInput, boolean expectedGameOver) {
		// given
		StrikeCountGameOverJudge strikeCountGameOverJudge = new StrikeCountGameOverJudge();
		Numbers myNumbers = Numbers.of(myNumbersInput);
		Numbers yourNumbers = Numbers.of(yourNumbersInput);
		HintsCount hintsCount = myNumbers.compareNumbers(yourNumbers);

		// when
		boolean gameOver = strikeCountGameOverJudge.isGameOver(hintsCount);

		// then
		assertThat(gameOver).isEqualTo(expectedGameOver);
	}

}
