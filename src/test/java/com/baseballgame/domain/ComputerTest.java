package com.baseballgame.domain;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@DisplayName("난수 생성 테스트")
	@Test
	void makeBaseballNumber() throws Exception{
		/* given */
		Computer computer = new Computer();

		/* when */
		computer.makeBaseballNumber();
		Field answerNumber = computer.getClass().getDeclaredField("answerNumber");
		answerNumber.setAccessible(true);
		String randomStr = (String)answerNumber.get(computer);
		String[] splittedRandomStr = randomStr.split("");

		/* then */
		assertThat(splittedRandomStr.length).isEqualTo(3);
		for (int i = 0; i < splittedRandomStr.length - 1; i++) {
			extracted(splittedRandomStr, i);
		}

	}

	private void extracted(String[] splittedRandomStr, int i) {
		for (int j = i + 1; j < splittedRandomStr.length; j++) {
			assertThat(!splittedRandomStr[i].equals(splittedRandomStr[j])).isTrue();
		}
	}

	@DisplayName("사용자 제출 답안 채점 : 3S")
	@Test
	void scoreUserAnswerCase1() throws Exception {
		/* given */
		Computer computer = new Computer();
		computer.makeBaseballNumber();
		Field answerNumber = computer.getClass().getDeclaredField("answerNumber");
		answerNumber.setAccessible(true);
		String randomStr = (String)answerNumber.get(computer);

		/* when */
		boolean b = computer.isAllMatches(randomStr);

		/* then */
		assertThat(b).isTrue();
	}
}