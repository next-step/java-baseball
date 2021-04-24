package com.chajs226.baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.chajs226.baseball.BaseballGame;

class BaseballGameTest {

	@DisplayName("서로 다른 3자리 숫자가 생성되었는지 확인")
	@Test	
	public void isdifferentThreeNumber() {
		
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
		final String baseballNumbers = baseballGame.makeRamdomNumbers();
		
		baseNumbers.remove(baseballNumbers.split("")[0]);
		baseNumbers.remove(baseballNumbers.split("")[1]);
		baseNumbers.remove(baseballNumbers.split("")[2]);
		
		//Then
		assertThat(baseballNumbers.length()).isEqualTo(3);
		assertThat(baseNumbers.size()).isEqualTo(6);
	}
}
