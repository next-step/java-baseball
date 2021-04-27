/*
 * @(#) BaseBallGameTest.java 2021. 04. 24.
 *
 */
package com.tistory.ddoriya.test;

import com.tistory.ddoriya.BaseBallGameService;
import com.tistory.ddoriya.BaseBallGameValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author 이상준
 */

public class BaseBallGameTest {
	private List<Integer> numbers;
	private BaseBallGameService baseBallGameService;

	@BeforeEach
	void setUp() {
		numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("야구게임 input 값을 특정 문자로 넣을 경우 NumberFormatException 발생 테스트")
	public void inputNumberFormatExceptionTest() {
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
			baseBallGameService = new BaseBallGameService();
			String input = "abc";
			baseBallGameService.executeGame(input);
		}).withMessageMatching("입력값 형식이 다릅니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "256:false"}, delimiter = ':')
	@DisplayName("입력값에 따른 정답 확인 테스트")
	public void gameCompletedTest(String input, boolean expected) {
		baseBallGameService = new BaseBallGameService(numbers);
		baseBallGameService.executeGame(input);
		assertThat(baseBallGameService.isGameCompleted()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:3 스트라이크", "256:1 볼", "456:낫싱", "125:2 스트라이크", "213:1 스트라이크2 볼"}, delimiter = ':')
	@DisplayName("입력값에 따른 게임 메시지 테스트")
	public void gameMessageTest(String input, String message) {
		baseBallGameService = new BaseBallGameService(numbers);
		baseBallGameService.executeGame(input);
		assertThat(baseBallGameService.getGameMessage()).isEqualTo(message);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "a56:false"}, delimiter = ':')
	@DisplayName("입력값이 숫자인지 테스트")
	public void numberValidTest(String input, boolean expected) {
		assertThat(BaseBallGameValidator.isNumberValid(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:false"}, delimiter = ':')
	@DisplayName("게임진행시 1,2 일경우 넘어갈수있도록 그외 다른값이 나오면 false 테스트")
	public void gameStartInputValidTest(String input, boolean expected) {
		assertThat(BaseBallGameValidator.isInputGameStatusValid(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "abc:true", "336:false"}, delimiter = ':')
	@DisplayName("중복되지않는 입력값의 사이즈가 3일 경우 true, 그외는 false 테스트")
	public void gameInputSizeValidTest(String input, boolean expected) {
		assertThat(BaseBallGameValidator.isSizeValid(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "486:true","abc:false", "336:false"}, delimiter = ':')
	@DisplayName("베이스볼 게임시 정상적인 input 인지 체크 하는 테스트")
	public void suerGameInputValidTest(String input, boolean expected) {
		assertThat(BaseBallGameValidator.isUserNumberValid(input)).isEqualTo(expected);
	}
}
