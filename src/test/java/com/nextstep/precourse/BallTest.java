package com.nextstep.precourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.nextstep.precourse.computer.Ball;

public class BallTest {

	private Ball ball = new Ball();
	private List<Integer> answerList;

	@BeforeEach
	void setUpRandomAnswerBall() {
		ball.makeRandomlyThreeDigitAnswer();
		answerList = ball.getAnswerList();
	}

	@Test
	@DisplayName("임의의 숫자가 3개 선택되었는지 테스트.")
	void isThreeDigitsGeneratedRandomBalls() {
		assertThat(answerList.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, -1, -3, 10, 11})
	@DisplayName("생성된 정답의 각 자리 숫자가 1~9까지의 숫자만 포함하는지 테스트.")
	void isContainsZeroOrTen(int paramNumber) {
		assertThat(answerList.contains(paramNumber)).isFalse();
	}
}
