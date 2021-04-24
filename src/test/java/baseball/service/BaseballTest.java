package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	@DisplayName("각 배열끼리 값 검증")
	void testValueCompare() {
		baseball.balls = new Balls("123");
		baseball.inputBalls = new Balls("123");
		baseball.valueCompare();
		
		assertEquals(3,baseball.strike);
        assertEquals(0,baseball.ball);
		
        assertThat(baseball.balls.getBalls()).filteredOn(inputB -> inputB.getBall().contains(baseball.inputBalls.getBalls().get(0).getBall()));       
	}

}
