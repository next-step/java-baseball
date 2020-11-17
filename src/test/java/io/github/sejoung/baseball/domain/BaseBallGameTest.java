package io.github.sejoung.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallGameTest {

	@DisplayName("1, 2 스트라이트 및 볼 테스트")
	@ParameterizedTest
	@CsvSource(value = {"125:2 스트라이크", "165:1 스트라이크", "451:1 볼", "431:2 볼", "231:3 볼",
		"135:1 스트라이크 1 볼", "132:1 스트라이크 2 볼"}, delimiter = ':')
	void oneTwoStrikeAndOneTwothreeBall(String input, String expected) {
		BaseBallGame baseBallGame = new BaseBallGame("123");
		String message = baseBallGame.play(input);
		assertThat(message.trim()).isEqualTo(expected);
	}

	@DisplayName("3 스트라이크 테스트")
	@Test
	void threeStrike() {
		BaseBallGame baseBallGame = new BaseBallGame("123");
		String message = baseBallGame.play("123");
		assertThat(message).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1,종료 하려면 2를 입력하세요.");

	}

	@DisplayName("낫싱 테스트")
	@Test
	void nothing() {
		BaseBallGame baseBallGame = new BaseBallGame("123");
		String message = baseBallGame.play("456");
		assertThat(message).isEqualTo("낫싱");
	}
}
