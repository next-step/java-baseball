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
}
