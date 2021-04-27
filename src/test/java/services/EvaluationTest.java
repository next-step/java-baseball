package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluationTest {
	private final Evaluation evaluation = new Evaluation();
	private List<Integer> problemNumber;

	@BeforeEach
	void setProblemNumber() {
		problemNumber = Arrays.asList(1, 2, 3);
	}

	@Test
	@DisplayName("한개의 숫자도 맞추지 못한 경우 0스트라이크, 0볼 이어야 한다")
	void oneStrikeOneBallTest() {
		// given
		String answerNumber = "456";

		// when
		evaluation.evaluate(answerNumber, problemNumber);

		//then
		assertThat(evaluation.getStrikeCount()).isEqualTo(0);
		assertThat(evaluation.getBallCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("입력한 숫자의 자리까지 정확히 맞춘 경우 맞춘 숫자의 개수와 스트라이크의 수가 같아야 한다")
	void strikeTest() {
		// given
		String answerNumber = "124";

		// when
		evaluation.evaluate(answerNumber, problemNumber);

		//then
		assertThat(evaluation.getStrikeCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("입력한 숫자가 문제 숫자에 포함 되면 그 숫자와 볼의 개수가 같아야 한다")
	void ballTest() {
		// given
		String answerNumber = "251";

		// when
		evaluation.evaluate(answerNumber, problemNumber);

		//then
		assertThat(evaluation.getBallCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("입력한 숫자가 문제 숫자에 포함 되거나 맞추면 그 숫자만큼 스트라이크와 볼의 개수와 같아야한다")
	void strikeAndBallTest() {
		// given
		String answerNumber = "132";

		// when
		evaluation.evaluate(answerNumber, problemNumber);

		//then
		assertThat(evaluation.getStrikeCount()).isEqualTo(1);
		assertThat(evaluation.getBallCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("스트라이크가 3개일 경우 정답")
	void hitAnswerTest() {
		// given
		String answerNumber = "123";
		evaluation.evaluate(answerNumber, problemNumber);

		// when
		evaluation.doesHitAnswer();

		// then
		assertThat(evaluation.doesHitAnswer()).isTrue();
	}
}
