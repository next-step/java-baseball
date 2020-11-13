package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class GuessResultTest {

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:3 스트라이크",
		"1:2:1 스트라이크 2 볼",
		"0:3:3 볼",
		"0:2:2 볼",
		"0:1:1 볼",
		"0:0:낫싱"
	}, delimiter = ':')
	void getMessage(int strikeCount, int ballCount, String expected) {
		assertThat(new GuessResult(strikeCount, ballCount).getMessage()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:true",
		"2:0:false"
	}, delimiter = ':')
	void isRight(int strikeCount, int ballCount, boolean expected) {
		assertThat(new GuessResult(strikeCount, ballCount).isRight()).isEqualTo(expected);
	}

	@Test
	void equals() {
		assertThat(new GuessResult(1, 2)).isEqualTo(new GuessResult(1, 2));
	}

}