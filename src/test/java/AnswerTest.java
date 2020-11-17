import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import NumberBaseballGame.Answer;

class AnswerTest {

	@DisplayName("정답 길이가 세자리인지 확인")
	@Test
	void answerLegnthThree() {
		Answer answer = new Answer();
		assertTrue(answer.getAnswer().length == 3);
	}

	@DisplayName("3자리의 숫자는 중복 불가")
	@Test
	void notDuplicate() {
		Answer answer = new Answer();
		int[] data = answer.getAnswer();

		assertAll(
			() -> assertFalse(data[0] == data[1]),
			() -> assertFalse(data[1] == data[2]),
			() -> assertFalse(data[2] == data[0]));
	}

}
