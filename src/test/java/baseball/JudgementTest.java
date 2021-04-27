package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {

	@DisplayName("판정 데이터로 출력할 메세지를 만든다.")
	@ParameterizedTest
	@CsvSource(
		value = {
			"3:3:0:3 스트라이크",
			"3:1:2:1 스트라이크 2 볼",
			"3:0:3:3 볼",
			"3:0:2:2 볼",
			"3:0:1:1 볼",
			"3:0:0:낫싱"
		},
		delimiter = ':'
	)
	void toMessage(
		int numberLength,
		int strikeCount,
		int ballCount,
		String expected
	) {
		Judgement judgement = new Judgement.Builder(numberLength, strikeCount, ballCount).build();
		String actual = judgement.toMessage();
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("판정 데이터가 주어졌을 때, 모두 스트라이크인지 여부를 반환한다.")
	@ParameterizedTest
	@CsvSource(
		value = {
			"3:3:0:true",
			"3:2:0:false"
		},
		delimiter = ':'
	)
	void isAllStrike(
		int numberLength,
		int strikeCount,
		int ballCount,
		boolean expected
	) {
		Judgement judgement = new Judgement.Builder(numberLength, strikeCount, ballCount).build();
		boolean actual = judgement.isAllStrike();
		assertThat(actual).isEqualTo(expected);
	}
}