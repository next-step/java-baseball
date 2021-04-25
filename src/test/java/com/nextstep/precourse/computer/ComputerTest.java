package com.nextstep.precourse.computer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	@Test
	@DisplayName("야구 게임 새 정답값 생성 테스트")
	public void generateNewAnswerTest() {
		Computer computer = new Computer();
		String newAnswer = computer.generateNewAnswer();
		char[] answerChars = newAnswer.toCharArray();
		List<Object> charList = Arrays.asList(answerChars);
		assertThat(charList).allMatch(ch -> Character.isDigit((char)ch))
			.doesNotContain('0')
			.hasSize(3);
		assertThat(
			answerChars[0] == answerChars[1] || answerChars[0] == answerChars[2] || answerChars[1] == answerChars[2]);
	}
}
