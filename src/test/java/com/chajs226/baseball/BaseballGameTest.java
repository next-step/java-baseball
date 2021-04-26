package com.chajs226.baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballGameTest {

	@DisplayName("서로 다른 3자리 랜덤 숫자가 생성되었는지 확인")
	@Test	
	public void testIsdifferentRandomThreeNumber() {
		
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		ArrayList<String> baseNumbers = new ArrayList<String>(); 
		baseNumbers.add("1");
		baseNumbers.add("2");
		baseNumbers.add("3");
		baseNumbers.add("4");
		baseNumbers.add("5");
		baseNumbers.add("6");
		baseNumbers.add("7");
		baseNumbers.add("8");
		baseNumbers.add("9");
				
		//When
		final String baseballNumbers = baseballGame.generateRandomNumbers();
		
		baseNumbers.remove(baseballNumbers.split("")[0]);
		baseNumbers.remove(baseballNumbers.split("")[1]);
		baseNumbers.remove(baseballNumbers.split("")[2]);
		
		//Then
		assertThat(baseballNumbers.length()).isEqualTo(3);
		assertThat(baseNumbers.size()).isEqualTo(6);
	}
	
	@DisplayName("랜덤으로 3자리 숫자 생성 기능에서 동일 숫자 입력 시, append 안되는 것 확인")
	@Test	
	public void testAppendNumberr_sameNumber_notAppend() {
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		//When
		final String getNumbers = baseballGame.appendNumber("3","3");
		//Then
		assertThat(getNumbers).isEqualTo("3");
	}
	
	@DisplayName("랜덤으로 3자리 숫자 생성 기능에서 append 기능 확인")
	@Test	
	public void testAppendNumberr_differentNumber_Append() {
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		//When
		final String getNumbers = baseballGame.appendNumber("4","3");
		//Then
		assertThat(getNumbers).isEqualTo("43");
	}	
	
	@DisplayName("retry, end game 메뉴 시, 1, 2만 입력가능한지 확인")
	@Test
	public void test_validateInputRetry() {
	
		//Given
		final BaseballGame baseballGame = new BaseballGame();
				
		//When-Then
		assertThat(baseballGame.validateInputRetry("1")).isEqualTo(true);
		assertThat(baseballGame.validateInputRetry("2")).isEqualTo(true);
	}
	
	@DisplayName("retry, end game 메뉴에서 1을 입력하면 true, 2를 입력하면 false 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false",}, delimiter = ':')
	public void test_checkInputRetry(String input, boolean expected) {
	
		//Given
		final BaseballGame baseballGame = new BaseballGame();
				
		//When-Then
		assertEquals(baseballGame.checkInputRetry(input), expected);
	}
	
	@DisplayName("숫자를 비교하여 위치에 따른 볼 카운트 update되는지 확인")
	@Test
	public void testUpdateBallCount() {
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		
		//When
		baseballGame.updateBallCount(1, "3", "432");
		
		//Then
		assertThat(baseballGame.strikeCount).isEqualTo(0);
		assertThat(baseballGame.ballCount).isEqualTo(1);
	}
	
	@DisplayName("입력된 3자리 숫자와 문제를 비교해서 정확한 볼카운트가 나오는지 확인")
	@Test
	public void testCompareInputAndRandomNumber_check_result() {
	
		//Given
		final BaseballGame baseballGame = new BaseballGame();
				
		//When
		baseballGame.compareInputAndRandomNumber("467","456");
		
		//Then
		assertThat(baseballGame.strikeCount).isEqualTo(1);
		assertThat(baseballGame.ballCount).isEqualTo(1);
	}
	
	
	@DisplayName("입력된 2자리 숫자를 문제와 비교하려고 할 떄 오류 확인")
	@Test
	public void testCompareInputAndRandomNumber_exception() {
	
		//Given
		final BaseballGame baseballGame = new BaseballGame();
				
		//When-Then
		assertThatThrownBy(() -> baseballGame.compareInputAndRandomNumber("12","456"))
				.isInstanceOf(RuntimeException.class)
				.hasMessage(("3자리 숫자만 입력 가능합니다."));		
	}
	
	@DisplayName("3자리 이하 숫자를 입력했을 때 false 리턴 확인")
	@Test
	public void testValidateInputNumberLength_false() {
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		
		//When
		boolean rtn = baseballGame.validateInputNumberLength("1");
		
		//Then
		assertThat(rtn).isEqualTo(false);
	}
	
	@DisplayName("3자리 숫자를 입력했을 때 true 리턴 확인")
	@Test
	public void testValidateInputNumberLength_true() {
		//Given
		final BaseballGame baseballGame = new BaseballGame();
		
		//When
		boolean rtn = baseballGame.validateInputNumberLength("175");
		
		//Then
		assertThat(rtn).isEqualTo(true);
	}
}
