package com.gotgolem.baseball.service;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;
import com.gotgolem.baseball.asset.pitch.Ball;
import com.gotgolem.baseball.asset.pitch.PitchHint;
import com.gotgolem.baseball.asset.pitch.ThreePitches;

public class BaseballServiceTest {

	private static BaseballService service;

	@BeforeAll
	public static void init() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		service = new BaseballService(numberGenerator);
	}

	@DisplayName("투구 생성 테스트")
	@Test
	public void whenCreatePitches_thenSuccess() {
		assertThat(service.createThreePitches())
				.isNotNull();
	}

	@DisplayName("특정 투구 생성 성공 테스트")
	@ParameterizedTest
	@CsvSource({"1,2,3", "4,5,6", "7,8,9"})
	public void whenCreatePitches_thenSuccess(int firstBallNumber, int secondBallNumber, int thirdBallNumber) {
		final int[] pitchNumbers = new int[] {firstBallNumber, secondBallNumber, thirdBallNumber};
		final ThreePitches pitches = service.createThreePitches(pitchNumbers);
		assertThat(pitches).isNotNull();
		assertThat(pitches.getFirst().ordinal() + 1).isEqualTo(firstBallNumber);
		assertThat(pitches.getSecond().ordinal() + 1).isEqualTo(secondBallNumber);
		assertThat(pitches.getThird().ordinal() + 1).isEqualTo(thirdBallNumber);
	}

	@DisplayName("특정 투구 생성 예외 테스트")
	@Test
	public void whenCreatePitches_thenThrow() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> service.createThreePitches(new int[] {1}));
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> service.createThreePitches(new int[] {1, 2, 3, 4}));
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> service.createThreePitches(new int[] {0, 1, 2}));
	}

	@DisplayName("투구 힌트 생성 테스트")
	@ParameterizedTest
	@CsvSource({"1,2,3,3,1,2,0,3", "5,9,1,4,5,1,1,1", "6,8,4,6,4,2,1,1", "4,5,6,7,8,9,0,0", "5,6,7,5,6,7,3,0"})
	public void whenComparePitches_thenExactHint(ArgumentsAccessor argumentsAccessor) {
		final ThreePitches pitches = new ThreePitches(asList(
				Ball.toBall(argumentsAccessor.getInteger(0)),
				Ball.toBall(argumentsAccessor.getInteger(1)),
				Ball.toBall(argumentsAccessor.getInteger(2))
		));
		final ThreePitches anotherPitches = new ThreePitches(asList(
				Ball.toBall(argumentsAccessor.getInteger(3)),
				Ball.toBall(argumentsAccessor.getInteger(4)),
				Ball.toBall(argumentsAccessor.getInteger(5))
		));
		final int strikeCount = argumentsAccessor.getInteger(6);
		final int ballCount = argumentsAccessor.getInteger(7);

		final PitchHint pitchHint = service.getPitchHint(pitches, anotherPitches);
		assertThat(pitchHint).isNotNull();
		assertThat(pitchHint.getStrikeCount())
				.as("스트라이크 개수")
				.isEqualTo(strikeCount);
		assertThat(pitchHint.getBallCount())
				.as("볼 개수")
				.isEqualTo(ballCount);
	}

}
