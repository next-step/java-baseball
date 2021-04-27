package com.precourse.baseball.count;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballCountTest {
	
	private BaseballCount count ;
	
	private Set<Integer> answer;
	
	@BeforeEach
	void setup() {
		this.count = new BaseballCount();
		
		this.answer = new LinkedHashSet<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(3);
	}
	
	@Test
	@DisplayName("Nothing 여부를 확인 한다.")	
	void nothingTest() {
		Set<Integer> answer = new LinkedHashSet<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(3);
		
		int[] userGuess = {4,5,6};
		
		count.refereeCall(answer, userGuess);
		
		boolean result = count.isNothing();
		
		assertThat(result).isTrue();

	}
	
	@Test
	@DisplayName("3 스트라이크 여부를 확인 한다.")	
	void strikeOutTest() {		
		
		int[] userGuess = {1,2,3};
		
		count.refereeCall(answer, userGuess);
		
		boolean result = count.isStrikeOut();
		
		assertThat(result).isTrue();

	}
	
	@Test
	@DisplayName("입력한 추측값이 볼이면 볼 처리 한다.")
	void isBallTest() {		
		
		int[] userGuess = {2,1,4};
		
		count.refereeCall(answer, userGuess);
		
		int strikeCount = count.getStrike();
		int ballCount = count.getBall();
		
		assertThat(strikeCount).isEqualTo(0);
		assertThat(ballCount).isEqualTo(2);

	}
	
	@Test
	@DisplayName("입력한 추측값이 스트라이크이면 스트라이크 처리 한다.(1스트라이크, 2스트라이크, 3스트라이크)")
	void isStrikeTest() {		
		
		int[] userGuess = {1,2,4};
		
		count.refereeCall(answer, userGuess);
		
		int strikeCount = count.getStrike();
		int ballCount = count.getBall();
		
		assertThat(ballCount).isEqualTo(0);
		assertThat(strikeCount).isEqualTo(2);

	}
	
	@Test
	@DisplayName("입력한 추측값이 스트라이크와 볼이면 각각 카운트 한다.(1스트라이크 1볼)")	
	void isStrikeAndBallTest() {		
		
		int[] userGuess = {1,4,2};
		
		count.refereeCall(answer, userGuess);
		
		int strikeCount = count.getStrike();
		int ballCount = count.getBall();
		
		assertThat(ballCount).isEqualTo(1);
		assertThat(strikeCount).isEqualTo(1);

	}
	
}
