package core;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : GenerateNumber test class
 *
 * Created by jychoi on 2021/04/26.
 */
class BaseballLogicTest {

	private final BaseballLogic baseballLogic = new BaseballLogic();

	private static final int INPUT_SIZE = 3;
	private static final int TEST_LOOP_SIZE = 10000;

	@Test
	@DisplayName("정답 생성 method validation check")
	void generateAnswer() {

		// 제약 조건
		// 1. 배열 내 원소들이 1~9의 int 원소
		// 2. 생성된 배열의 길이가 INPUT_SIZE와 같은 지
		for (int idx = 0; idx < TEST_LOOP_SIZE; idx++) {
			Integer[] given = baseballLogic.generateAnswer(INPUT_SIZE);
			assertThat(given.length).isEqualTo(INPUT_SIZE);
			assertThat(given).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
		}
	}

	@Test
	@DisplayName("정답 정상 출력 확인")
	void run() {
		Integer[] answer = baseballLogic.generateAnswer(INPUT_SIZE);
		AnswerObject given = baseballLogic.run(answer, answer);
		AnswerObject when = new AnswerObject(INPUT_SIZE, 0);
		assertThat(given).isEqualTo(when);
	}

	@Test
	@DisplayName("정답 비정상 출력 확인")
	void runFailCase() {
		Integer[] answer = baseballLogic.generateAnswer(INPUT_SIZE);
		AnswerObject given = baseballLogic.run(answer, answer);
		AnswerObject when = new AnswerObject(0, INPUT_SIZE);
		assertThat(given).isNotEqualTo(when);
	}
}
