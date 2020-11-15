package baseball.domain;

import static baseball.domain.BaseballStatus.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.exception.ResultLengthException;

class BaseballResultTest {

	@Test
	@DisplayName("3 스트라이크 결과 확인")
	void result_three_strike() {
		final BaseballResult baseballResult =
			BaseballResult.of(Arrays.asList(STRIKE, STRIKE, STRIKE));

		String expected = String.format(STRIKE.getMessageFormat(), 3);
		assertThat(baseballResult.getResultMessage()).isEqualTo(expected);
	}

	@Test
	@DisplayName("3 볼 결과 확인")
	void result_three_ball() {
		final BaseballResult baseballResult =
			BaseballResult.of(Arrays.asList(BALL, BALL, BALL));

		String expected = String.format(BALL.getMessageFormat(), 3);
		assertThat(baseballResult.getResultMessage()).isEqualTo(expected);
	}

	@Test
	@DisplayName("낫싱 결과 확인")
	void result_nothing() {
		final BaseballResult baseballResult =
			BaseballResult.of(Arrays.asList(NOTHING, NOTHING, NOTHING));

		String expected = NOTHING.getMessageFormat();
		assertThat(baseballResult.getResultMessage()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"STRIKE:STRIKE:BALL",
		"STRIKE:BALL:STRIKE",
		"BALL:STRIKE:STRIKE",
	}, delimiter = ':')
	@DisplayName("2 스트라이크 1볼 결과 확인")
	void result_two_strike_one_ball(BaseballStatus first, BaseballStatus second, BaseballStatus third) {
		final BaseballResult baseballResult =
			BaseballResult.of(Arrays.asList(first, second, third));

		String expected = String.format(STRIKE.getMessageFormat(), 2) + String.format(BALL.getMessageFormat(), 1);
		assertThat(baseballResult.getResultMessage()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"STRIKE:BALL:BALL",
		"BALL:BALL:STRIKE",
		"BALL:STRIKE:BALL",
	}, delimiter = ':')
	@DisplayName("1 스트라이크 2볼 결과 확인")
	void result_one_strike_two_ball(BaseballStatus first, BaseballStatus second, BaseballStatus third) {
		final BaseballResult baseballResult =
			BaseballResult.of(Arrays.asList(first, second, third));

		String expected = String.format(STRIKE.getMessageFormat(), 1) + String.format(BALL.getMessageFormat(), 2);
		assertThat(baseballResult.getResultMessage()).isEqualTo(expected);
	}

	@Test
	@DisplayName("3개 이상의 결과가 넘어오면 예외발생")
	void result_size_exception() {
		assertThatThrownBy(() -> BaseballResult.of(Arrays.asList(STRIKE, STRIKE, STRIKE, STRIKE)))
			.isInstanceOf(ResultLengthException.class)
			.hasMessage("결과의 개수가 너무 많습니다.");
	}

	@Test
	@DisplayName("3 스트라이크이면 isEnd 가 true 를 반환한다.")
	void result_isOut_true() {
		assertThat(BaseballResult.of(Arrays.asList(STRIKE, STRIKE, STRIKE)).isOut()).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"STRIKE:BALL:BALL",
		"BALL:BALL:STRIKE",
		"BALL:STRIKE:BALL",
		"STRIKE:STRIKE:BALL",
		"BALL:STRIKE:STRIKE",
		"STRIKE:BALL:BALL",
		"BALL:BALL:BALL"
	}, delimiter = ':')
	@DisplayName("3 스트라이크가 아니면 isEnd 가 false 를 반환한다.")
	void result_isOut_false(BaseballStatus first, BaseballStatus second, BaseballStatus third) {
		assertThat(BaseballResult.of(Arrays.asList(first, second, third)).isOut()).isFalse();
	}
}