package com.nextstep.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballInningTest {
	private BaseballInning inning;

	@BeforeEach
	void setup() {
		inning = new BaseballInning();
	}

	@Test
	@DisplayName("객체 생성 확인")
	void create() {
		assertThat(inning).isNotNull();
	}
	
	@Test
	@DisplayName("게임이 정상적으로 시작되었는지 확인")
	void start() {
		int testcase = 789;
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo(inning.NOT_STARTED);
		inning.start();
		answer = inning.pitchAndHit(testcase);
		assertThat(answer).isNotEqualTo(inning.NOT_STARTED);
		assertThat(answer).isNotEqualTo(inning.NOT_VALID_PARAM);
	}
}
