package number;

import static number.MatchResult.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchResultTest {

	@ParameterizedTest
	@DisplayName("두 야구숫자들끼리 같은 숫자를 포함하는가, 그 숫자가 위치가 같은가에 따라서 올바른 결과를 내는지 테스트")
	@CsvSource(value = {"true:true:STRIKE", "true:false:BALL", "false:false:NOT_MATCH"}, delimiter = ':')
	public void applyMatchRuleTest(boolean containEqualNumber, boolean equalPosition, MatchResult expectedResult) {
		// when
		MatchResult actualResult = applyMatchRules(containEqualNumber, equalPosition);

		// then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

}

