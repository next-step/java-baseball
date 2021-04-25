package ttuop.nextstep.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

	@ParameterizedTest
	@CsvSource({"123,3", "125,2", "145,1", "456,0", ",-1", "111,-1", "1234,-1", "abc,-1"})
	@DisplayName("스트라이크 판정 테스트")
	void testFindStrike(String input, int expected) {
		Referee referee = new Referee("123");

		int strike = referee.findStrike(input);

		assertThat(strike).isEqualTo(expected);
	}

}
