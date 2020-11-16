package services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberEvaluatorTest {

	private final AnswerNumberEvaluator answerNumberEvaluator = new AnswerNumberEvaluator();

	@Test
	@DisplayName("Get strike count and ball count from answer number")
	void evaluationTest() {
		List<Integer> problemNumber = Arrays.asList(1, 2, 3);
		String answerNumber = "132";

		Evaluation actual = answerNumberEvaluator.evaluate(answerNumber, problemNumber);

		assertThat(actual.getStrikeCount()).isEqualTo(1);
		assertThat(actual.getBallCount()).isEqualTo(2);
	}
}
