package com.precourse.baseball.answer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballAnswerTest {
	private BaseballAnswer answer;
	
	@BeforeEach
	void setup() {
		this.answer = new BaseballAnswer();
	}
	
	@Test
	@DisplayName("정답값의 자릿수는 세자리 이다.")
	void answerSizeTest() {

		assertThat(answer.getAnswer().size()).isEqualTo(0);
		
		answer.generate();
		
		assertThat(answer.getAnswer().size()).isEqualTo(3);
 
	}
	
	@Test
	@DisplayName("정답값은 서로 중복되지 않는다.(Set 자료구조는 중복 허용 안함)")
	void answerGenerateSizeTest() {
		
		answer.generate();
		
		assertThat(answer.getAnswer().size()).isEqualTo(3);
 
	}
	
	@Test
	@DisplayName("정답값의 요소는 1~9 범위 이다.")
	void answerNumberShouldBe1To9Test() {
		
		answer.generate();
		
		Iterator<Integer> it = answer.getAnswer().iterator();
		while(it.hasNext()) {
			assertThat(it.next()).isBetween(1,9);
		}
	}

	
}
