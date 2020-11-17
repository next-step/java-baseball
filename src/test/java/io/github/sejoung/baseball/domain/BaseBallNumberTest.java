package io.github.sejoung.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.github.sejoung.util.TestUtils;

class BaseBallNumberTest {

	@DisplayName("1, 2 스트라이트 및 볼 테스트")
	@ParameterizedTest
	@CsvSource(value = {"125:2 스트라이크", "165:1 스트라이크", "451:1 볼", "431:2 볼", "231:3 볼"}, delimiter = ':')
	void oneTwoStrikeAndOneTwothreeBall(String input, String expected) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(TestUtils.makeNumberList("123"), input);
		assertThat(assertThat(baseBallNumber.check().trim())
			.isEqualTo(expected));
		assertThat(baseBallNumber.isThreeStrike()).isFalse();
	}

	@DisplayName("3 스트라이크")
	@Test
	void threeStrikeMessage() {
		BaseBallNumber baseBallNumber = new BaseBallNumber(TestUtils.makeNumberList("123"), "123");
		assertThat(baseBallNumber.check())
			.isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1,종료 하려면 2를 입력하세요.");
		assertThat(baseBallNumber.isThreeStrike()).isTrue();
	}

}
