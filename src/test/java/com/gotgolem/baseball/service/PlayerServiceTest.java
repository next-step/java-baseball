package com.gotgolem.baseball.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.gotgolem.baseball.asset.game.GameState;
import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;
import com.gotgolem.baseball.asset.pitch.Ball;
import com.gotgolem.baseball.asset.pitch.ThreePitches;
import com.gotgolem.baseball.asset.player.Player;
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

	@DisplayName("문자열에 맞는 GameState 변환 성공 테스트")
	@ParameterizedTest
	@CsvSource({"1,START", "2,END", "  1,START", " 2,END"})
	public void whenParseGameStateString_thenExact(String gameStateString, GameState expectGameState) {
		final GameState gameState = service.parseGameStateString(gameStateString);
		assertThat(gameState).isEqualTo(expectGameState);
	}

	@DisplayName("GameState 변환 예외 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "12", "0", "#"})
	public void whenParseGameStateString_thenThrow(String gameStateString) {
		assertThatExceptionOfType(PlayerInputException.class)
				.isThrownBy(() -> service.parseGameStateString(gameStateString));
	}

	@DisplayName("상대방(컴퓨터)의 투구 저장 테스트")
	@Test
	public void savePitchesOfComputerPlayer() {
		final Player computer = new Player();
		service.changePlayerPitches(computer);
		assertThat(computer.getPitches()).isNotNull();
	}

}
