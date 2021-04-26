package com.gotgolem.baseball.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;
import com.gotgolem.baseball.asset.pitch.Ball;
import com.gotgolem.baseball.asset.pitch.ThreePitches;
import com.gotgolem.baseball.exception.PlayerInputException;

public class PlayerServiceTest {

	private static PlayerService service;

	@BeforeAll
	public static void init() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final BaseballService baseballService = new BaseballService(numberGenerator);
		service = new PlayerService(baseballService);
	}

	@DisplayName("문자열에 맞는 Pitches 객체 생성 확인 테스트")
	@ParameterizedTest
	@CsvSource({"319 ,CHANGE_UP,FAST,SLIDE", "5 6 1,FORK,SINKER,FAST", " 7 9  2,CURVE,SLIDE,BREAKING"})
	public void whenParsePitchesString_thenExact(
			String pitchesString, Ball firstPitch, Ball secondPitch, Ball thirdPitch) {

		final ThreePitches pitches = service.parsePitchesString(pitchesString);
		assertThat(pitches).isNotNull();
		assertThat(pitches.getFirst()).isEqualTo(firstPitch);
		assertThat(pitches.getSecond()).isEqualTo(secondPitch);
		assertThat(pitches.getThird()).isEqualTo(thirdPitch);
	}

	@DisplayName("Pitches 객체 생성 예외 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"31a3", "223", "012", "933", "1234", "12"})
	public void whenParsePitchesString_thenThrow(String pitchesString) {
		assertThatExceptionOfType(PlayerInputException.class)
				.isThrownBy(() -> service.parsePitchesString(pitchesString));
	}

}
