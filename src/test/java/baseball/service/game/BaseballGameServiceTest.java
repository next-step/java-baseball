package baseball.service.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.testutils.IntegerListConverter;

public class BaseballGameServiceTest {
	private final BaseballGameService baseballGameService = new BaseballGameService();

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;1,5,9",
		"1,2,3;1,2,3"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnThreeStrike(
			@ConvertWith(IntegerListConverter.class) List<Integer> answer,
			@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getStrikeCount(answer, userAnswer)).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;4,5,9",
		"1,2,3;1,4,3"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnTwoStrike(
			@ConvertWith(IntegerListConverter.class) List<Integer> answer,
			@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getStrikeCount(answer, userAnswer)).isEqualTo(2);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;9,1,5",
		"1,2,3;5,6,7"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnZeroStrike(
		@ConvertWith(IntegerListConverter.class) List<Integer> answer,
		@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getStrikeCount(answer, userAnswer)).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;5,9,1",
		"1,2,3;2,3,1"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnThreeBall(
		@ConvertWith(IntegerListConverter.class) List<Integer> answer,
		@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getBallCount(answer, userAnswer)).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;5,3,1",
		"1,2,3;3,2,1"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnTwoBall(
		@ConvertWith(IntegerListConverter.class) List<Integer> answer,
		@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getBallCount(answer, userAnswer)).isEqualTo(2);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,5,9;1,5,9",
		"1,2,3;5,6,7"
	}, delimiterString = ";")
	public void getStrikeCount_WhenCalled_ShouldReturnZeroBall(
		@ConvertWith(IntegerListConverter.class) List<Integer> answer,
		@ConvertWith(IntegerListConverter.class) List<Integer> userAnswer) {
		assertThat(baseballGameService.getBallCount(answer, userAnswer)).isEqualTo(0);
	}
}
