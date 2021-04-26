package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:3 스트라이크",
		"1:2:1 스트라이크 2 볼",
		"0:3:3 볼",
		"0:2:2 볼",
		"0:1:1 볼",
		"0:0:낫싱"
	}, delimiter = ':')
	void toMessage(int strikeCount, int ballCount, String expected) {
		Judgement judgement = new Judgement.Builder(strikeCount, ballCount).build();
		String actual = judgement.toMessage();
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:true",
		"2:0:false"
	}, delimiter = ':')
	void is3Strike(int strikeCount, int ballCount, boolean expected) {
		Judgement judgement = new Judgement.Builder(strikeCount, ballCount).build();
		boolean actual = judgement.is3Strike();
		assertThat(actual).isEqualTo(expected);
	}
}