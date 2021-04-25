package com.numberbaseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallGameTest {

	private NumberBaseBallGame numberBaseBallGame;

	@BeforeEach
	void init() {
		numberBaseBallGame = new NumberBaseBallGame();
	}

	@Test
	@DisplayName("전부 틀린 경우")
	void 전부_틀린_경우() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(425, 789);

		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("정답인 경우")
	void 정답인_경우() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(425, 425);

		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자만 맞춘 경우")
	void 숫자만_맞춘_경우() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(425, 542);

		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(3);
	}

	@Test
	@DisplayName("스트라이크와 볼이 섞인 경우")
	void 스트라이크_볼_모두_있는_경우() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(425, 452);

		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(2);
	}

	@Test
	@DisplayName("예제 케이스1")
	void 예제_1() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(713, 123);

		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("예제 케이스2")
	void 예제_2() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(713, 145);

		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("예제 케이스3")
	void 예제_3() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(713, 671);

		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(2);
	}

	@Test
	@DisplayName("예제 케이스4")
	void 예제_4() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(713, 216);

		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("예제 케이스5")
	void 예제_5() {
		NumberBaseBallResult result = numberBaseBallGame.toResult(713, 713);

		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("스트라이크만 있는 경우 출력 결과")
	void 스트라이크_출력_테스트() {
		NumberBaseBallResult result = NumberBaseBallResult.of(3, 0);

		assertThat(result.toStr()).isEqualTo("3 스트라이크");
	}

	@Test
	@DisplayName("볼만 있는 경우 출력 결과")
	void 볼_출력_테스트() {
		NumberBaseBallResult result = NumberBaseBallResult.of(0, 1);

		assertThat(result.toStr()).isEqualTo("1볼");
	}

	@Test
	@DisplayName("스트라이크와 볼이 있는 경우 출력 결과")
	void 스트라이크_볼_출력_테스트() {
		NumberBaseBallResult result = NumberBaseBallResult.of(2, 1);

		assertThat(result.toStr()).isEqualTo("2 스트라이크 1볼");
	}

	@Test
	@DisplayName("아무것도 맞추지 못한 경우 출력 결과")
	void 낫싱_테스트() {
		NumberBaseBallResult result = NumberBaseBallResult.of(0, 0);

		assertThat(result.toStr()).isEqualTo("낫싱");
	}

}