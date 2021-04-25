package com.nextstep.precourse.computer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	private Computer computer;

	@BeforeEach
	public void init() {
		computer = new Computer();
	}

	@Test
	@DisplayName("야구 게임 새 정답값 생성 테스트")
	public void generateNewAnswerTest() {
		String newAnswer = computer.generateNewAnswer();
		char[] answerChars = newAnswer.toCharArray();
		List<Object> charList = Arrays.asList(answerChars);
		assertThat(charList).allMatch(ch -> Character.isDigit((char)ch))
			.doesNotContain('0')
			.hasSize(3);
		assertThat(
			answerChars[0] == answerChars[1] || answerChars[0] == answerChars[2] || answerChars[1] == answerChars[2]);
	}

	@Test
	@DisplayName("입력된 값으로 스트라이크, 볼 갯수 카운팅")
	public void checkStrikeBallTest() {
		String answer = "123";
		String[] inputs = {"123", "231", "456", "156", "256"};
		int[][] results = {{3, 0}, {0, 3}, {0, 0}, {1, 0}, {0, 1}};

		assertThat(Arrays.asList(inputs)).map(input -> computer.checkStrikeBall((String)input, answer))
			.containsExactly(results);
	}

	@Test
	@DisplayName("입력된 값 정답 여부 확인")
	public void checkAnswerTest() {
		String answer = "123";
		String[] inputs = {"123", "231", "456", "156", "256"};

		computer.setAnswer(answer);
		assertThat(Arrays.asList(inputs)).map(input -> computer.checkAnswer((String)input))
			.containsExactly(true, false, false, false, false);
	}
}
