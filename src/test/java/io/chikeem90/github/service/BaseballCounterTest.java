package io.chikeem90.github.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.chikeem90.github.domain.BaseballCount;

class BaseballCounterTest {
	@Test
	@DisplayName("countBaseball 3 스트라이크 테스트")
	public void countBaseballTest_1() {
		BaseballCounter baseballCounter = new BaseballCounter();
		List<Character> generatedNumber = new ArrayList<>(Arrays.asList('1', '2', '3'));
		List<Character> inputNumber = new ArrayList<>(Arrays.asList('1', '2', '3'));
		BaseballCount baseballCount = baseballCounter.countBaseball(generatedNumber, inputNumber);
		assertThat(baseballCount.getStrikeCount()).isEqualTo(3);
		assertThat(baseballCount.getBallCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("countBaseball 1 스트라이크 2 볼 테스트")
	public void countBaseballTest_2() {
		BaseballCounter baseballCounter = new BaseballCounter();
		List<Character> generatedNumber = new ArrayList<>(Arrays.asList('3', '2', '1'));
		List<Character> inputNumber = new ArrayList<>(Arrays.asList('1', '2', '3'));
		BaseballCount baseballCount = baseballCounter.countBaseball(generatedNumber, inputNumber);
		assertThat(baseballCount.getStrikeCount()).isEqualTo(1);
		assertThat(baseballCount.getBallCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("countBaseball 낫싱 테스트")
	public void countBaseballTest_3() {
		BaseballCounter baseballCounter = new BaseballCounter();
		List<Character> generatedNumber = new ArrayList<>(Arrays.asList('4', '5', '6'));
		List<Character> inputNumber = new ArrayList<>(Arrays.asList('1', '2', '3'));
		BaseballCount baseballCount = baseballCounter.countBaseball(generatedNumber, inputNumber);
		assertThat(baseballCount.getStrikeCount()).isEqualTo(0);
		assertThat(baseballCount.getBallCount()).isEqualTo(0);
	}
}