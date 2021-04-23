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

		List<Object> charList = Arrays.asList(newAnswer.toCharArray());
		assertThat(charList).allMatch(ch -> Character.isDigit((char)ch))
			.hasSize(3);
	}
}
