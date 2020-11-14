package com.woowahan.camp.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.woowahan.camp.constant.Message;

class GameResultTest {

	@DisplayName("of 메서드로 GameResult 객체를 생성할 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371", "3:0:327:327", "0:2:327:132", "2:0:327:325", "0:0:327:456"}, delimiter = ':')
	void ofTest(int strike, int ball, String computerValue, String userValue) {
		//Given
		//When
		GameResult result = GameResult.of(strike, ball, computerValue, userValue);

		//Then
		assertThat(result).isInstanceOf(GameResult.class);
	}

	@DisplayName("isWin 메서드로 승리여부를 boolean 값으로 받을 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371:false", "3:0:327:327:true", "0:2:327:132:false", "2:0:327:325:false",
		"3:0:498:498:true"}, delimiter = ':')
	void isWinTest(int strike, int ball, String computerValue, String userValue, boolean expected) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		boolean result = gameResult.isWin();

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("getStrike 메서드로 GameResult 객체의 strike값을 얻을 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371", "3:0:327:327", "0:2:327:132", "2:0:327:325", "0:0:327:456"}, delimiter = ':')
	void getStrikeTest(int strike, int ball, String computerValue, String userValue) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		int result = gameResult.getStrike();

		//Then
		assertThat(result).isEqualTo(strike);
	}

	@DisplayName("getBall 메서드로 GameResult 객체의 ball값을 얻을 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371", "3:0:327:327", "0:2:327:132", "2:0:327:325", "0:0:327:456"}, delimiter = ':')
	void getBallTest(int strike, int ball, String computerValue, String userValue) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		int result = gameResult.getBall();

		//Then
		assertThat(result).isEqualTo(ball);
	}

	@DisplayName("getResultMsg 메서드는 결과 메세지를 빈문자가 아닌 문자열로 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371", "3:0:327:327", "0:2:327:132", "2:0:327:325", "0:0:327:456"}, delimiter = ':')
	void getResultMsgTest(int strike, int ball, String computerValue, String userValue) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String result = gameResult.getResultMsg();

		//Then
		assertThat(result).isNotBlank();
	}

	@DisplayName("getStrikeMsg 메서드는 스트라이크 값이 0보다 크고 3보다 작을때 Message.STRIKE_MSG를 반환하고, 그 이외에는 빈문자열을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371:true", "3:0:327:327:false", "0:2:327:132:false", "2:0:327:325:true",
		"0:0:327:456:false"}, delimiter = ':')
	void getStrikeMsgTest(int strike, int ball, String computerValue, String userValue, boolean expected) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String msg = gameResult.getStrikeMsg();
		boolean result = String.format(Message.STRIKE_MSG, strike).equals(msg);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("getBallMsg 메서드는 볼 값이 0보다 클 때  Message.BALL_MSG를 반환하고, 그 이외에는 빈문자열을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371:true", "3:0:327:327:false", "0:2:327:132:true", "2:0:327:325:false",
		"0:0:327:456:false"}, delimiter = ':')
	void getBallMsgTest(int strike, int ball, String computerValue, String userValue, boolean expected) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String msg = gameResult.getBallMsg();
		boolean result = String.format(Message.BALL_MSG, ball).equals(msg);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("getWinMsg 메서드는 스트라이크 값이 3일때 Message.GAME_WIN_MSG를 반환하고, 그 이외에는 빈문자열을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371:false", "3:0:327:327:true", "0:2:327:132:false", "2:0:327:325:false",
		"0:0:327:456:false"}, delimiter = ':')
	void getWinMsgTest(int strike, int ball, String computerValue, String userValue, boolean expected) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String msg = gameResult.getWinMsg();
		boolean result = Message.GAME_WIN_MSG.equals(msg);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("getNothingMsg 메서드는 스트라이크 값과 볼 값이 모두 0일때 Message.NOTHING_MSG를 반환하고, 그 이외에는 빈문자열을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371:false", "3:0:327:327:false", "0:2:327:132:false", "2:0:327:325:false",
		"0:0:327:456:true"}, delimiter = ':')
	void getNothingMsgTest(int strike, int ball, String computerValue, String userValue, boolean expected) {
		//Given
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String msg = gameResult.getNothingMsg();
		boolean result = Message.NOTHING_MSG.equals(msg);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("toString 메서드는 필드 값을 문자열로 출력한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:327:371", "3:0:327:327", "0:2:327:132", "2:0:327:325", "0:0:327:456"}, delimiter = ':')
	void testToString(int strike, int ball, String computerValue, String userValue) {
		//Given
		final StringBuilder sb = new StringBuilder("GameResult{");
		sb.append("strike=").append(strike);
		sb.append(", ball=").append(ball);
		sb.append(", computerValue='").append(computerValue).append('\'');
		sb.append(", userValue='").append(userValue).append('\'');
		sb.append('}');
		String expected = sb.toString();
		GameResult gameResult = GameResult.of(strike, ball, computerValue, userValue);

		//When
		String result = gameResult.toString();

		//Then
		assertThat(result).isEqualTo(expected);
	}
}