import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
	private BaseballGame baseballGame;
	private Answer answer;
	private Question question;
	private List<Integer> answerList;

	@BeforeEach
	void setUp() {
		answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);
		answer = new Answer();
		answer.setAnswer(answerList);

		question = new Question();
		question.setUserQuestion(3, 2, 4);

		baseballGame = new BaseballGame(answer, question);
	}

	@Test
	void feedbackTest() {
		assertThat(baseballGame.feedback(answer, question).getStrike()).isEqualTo(1);
		assertThat(baseballGame.feedback(answer, question).getBall()).isEqualTo(1);
	}
}
