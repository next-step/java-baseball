package baseball.domain;

import static baseball.domain.BaseballStatus.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.exception.DuplicateNumberInputException;
import baseball.domain.exception.NumbersLengthException;

class BaseballNumbersTest {

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:3",
		"0:3:5",
		"8:9:3"
	}, delimiter = ':')
	@DisplayName("중복되지 않은 3자리수가 입력되면 정상 생성된다.")
	void generateNumbers(int first, int second, int third) {
		final BaseballNumbers baseballNumbers =
			BaseballNumbers.of(Arrays.asList(first, second, third));

		assertThat(baseballNumbers).isInstanceOf(BaseballNumbers.class);
		assertThat(baseballNumbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:2:3",
		"0:0:5",
		"4:4:4"
	}, delimiter = ':')
	@DisplayName("중복된 숫자 입력시 예외가 발생한다.")
	void duplicate_exception(int first, int second, int third) {
		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(first, second, third)))
			.isInstanceOf(DuplicateNumberInputException.class)
			.hasMessage("중복된 숫자가 입력될 수 없습니다.");
	}

	@Test
	@DisplayName("입력된 숫자가 세자리수가 아니면 예외가 발생한다.")
	void parameter_length_exception() {
		final String ERROR_MESSAGE = "3 자리수 숫자로만 생성할 수 있습니다.";

		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> BaseballNumbers.of(Collections.singletonList(0)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(1, 2)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> BaseballNumbers.of(Collections.emptyList()))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage(ERROR_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:3",
		"0:3:5",
		"8:9:3"
	}, delimiter = ':')
	@DisplayName("값이 모두 일치하면 3 스트라이크")
	void calculate_score_out(int first, int second, int third) {
		final BaseballNumbers baseballNumbers = BaseballNumbers.of(Arrays.asList(first, second, third));
		final List<BaseballStatus> threeStrike = baseballNumbers.calculateScore(
			BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(threeStrike).containsExactly(STRIKE, STRIKE, STRIKE);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:5",
		"4:2:3",
		"1:2:4",
		"1:4:3"
	}, delimiter = ':')
	@DisplayName("값과 위치가 두개만 일치하면 2 스트라이크")
	void calculate_score_two_strike(int first, int second, int third) {
		final List<BaseballStatus> oneStrike = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(oneStrike).containsExactlyInAnyOrder(STRIKE, STRIKE, NOTHING);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:4:5",
		"4:8:3",
		"6:2:4",
		"1:4:5"
	}, delimiter = ':')
	@DisplayName("값과 위치가 하나만 일치하면 1 스트라이크")
	void calculate_score_one_strike(int first, int second, int third) {
		final List<BaseballStatus> oneStrike = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(oneStrike).containsExactlyInAnyOrder(STRIKE, NOTHING, NOTHING);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:1:2",
		"2:3:1"
	}, delimiter = ':')
	@DisplayName("값이 같지만 위치가 다른수가 3개면 3볼")
	void calculate_score_three_ball(int first, int second, int third) {
		final List<BaseballStatus> threeBall = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(threeBall).containsExactly(BALL, BALL, BALL);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:1:4",
		"0:3:1",
		"2:0:1"
	}, delimiter = ':')
	@DisplayName("값이 같지만 위치가 다른수가 2개면 2볼")
	void calculate_score_two_ball(int first, int second, int third) {
		final List<BaseballStatus> twoBall = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(twoBall).containsExactlyInAnyOrder(BALL, BALL, NOTHING);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:0:4",
		"0:3:8",
		"9:0:1"
	}, delimiter = ':')
	@DisplayName("값이 같지만 위치가 다른수가 1개면 1볼")
	void calculate_score_one_ball(int first, int second, int third) {
		final List<BaseballStatus> oneBall = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(oneBall).containsExactlyInAnyOrder(BALL, NOTHING, NOTHING);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"9:0:4",
		"0:6:8",
		"9:0:7"
	}, delimiter = ':')
	@DisplayName("값이 모두 다르면 모두 빗나간다.")
	void calculate_score_nothing(int first, int second, int third) {
		final List<BaseballStatus> oneBall = BaseballNumbers.of(Arrays.asList(1, 2, 3))
			.calculateScore(BaseballNumbers.of(Arrays.asList(first, second, third)));

		assertThat(oneBall).containsExactlyInAnyOrder(NOTHING, NOTHING, NOTHING);
	}
}