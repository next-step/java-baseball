package ttuop.nextstep.baseball;

import static org.junit.jupiter.api.Assertions.*;
import static ttuop.nextstep.baseball.Constants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

	@Test
	@DisplayName("야구게임 정답이 정해진 규칙에 일치하는지 테스트")
	void testIsCorrectAnswer() {
		AnswerGenerator generator = new AnswerGenerator();
		String answer = generator.generate();

		assertTrue(answer.matches(REGEX_OF_ANSWER));
	}

}
