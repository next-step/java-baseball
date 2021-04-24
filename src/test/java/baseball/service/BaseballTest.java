package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Balls;

class BaseballTest {

	private Baseball baseball;
	
	@BeforeEach
	void setUp() throws Exception {
		baseball = new Baseball();
	}

	@Test
	@DisplayName("자동 설정값 3자리 검증")
	void testGenerateAutoNumber() {

		Balls testBalls = baseball.generateAutoNumber();
		assertThat(testBalls.getBalls()).isNotEmpty().hasSize(3);
	}

	@Test
	@DisplayName("입력값 3자리 검증")	
	void testRegisterBallNumbers() {
		Balls testBalls = baseball.registerBallNumbers("123");
		assertThat(testBalls.getBalls()).isNotEmpty().hasSize(3);
	}

}
