package com.gotgolem.baseball.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;

public class BaseballServiceTest {

	private static BaseballService service;

	@BeforeAll
	public static void init() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		service = new BaseballService(numberGenerator);
	}

	@DisplayName("투구 생성 테스트")
	@Test
	public void whenCreatePitches_thenSuccess() {
		assertThat(service.createThreePitches())
				.isNotNull();
	}

}
