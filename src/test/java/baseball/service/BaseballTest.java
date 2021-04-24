package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.Balls;

class BaseballTest {

	private Baseball baseball;
	
	@BeforeEach
	void setUp() throws Exception {
		baseball = new Baseball();
	}

	@Test
	void testGenerateAutoNumber() {
		//assertThat("The Lord of the Rings").isNotNull() .startsWith("The") .contains("Lord") .endsWith("Rings");
		Balls testBalls = baseball.generateAutoNumber();
		assertThat(testBalls.getBalls()).isNotEmpty().hasSize(3);
	}

	@Test
	void testMakeBalls() {
		//fail("Not yet implemented");
	}

}
