import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionTest {
	private Question question;

	@BeforeEach
	void setUp() {
		question = new Question();
		List<Integer> userQuestion = new ArrayList<>();
		userQuestion.add(1);
		userQuestion.add(2);
		userQuestion.add(3);
		question.setUserQuestion(userQuestion);
	}

	@Test
	void setUserQuestionTest() {
		List<Integer> userQuestion = new ArrayList<>();
		userQuestion.add(3);
		userQuestion.add(2);
		userQuestion.add(1);
		question.setUserQuestion(userQuestion);

		assertThat(question.getUserQuestion().size()).isEqualTo(3);
		assertThat(question.getUserQuestion().get(0)).isEqualTo(3);
		assertThat(question.getUserQuestion().get(1)).isEqualTo(2);
		assertThat(question.getUserQuestion().get(2)).isEqualTo(1);
	}

	@Test
	void getUserQuestionTest() {
		assertThat(question.getUserQuestion().size()).isEqualTo(3);
		assertThat(question.getUserQuestion().get(0)).isEqualTo(1);
		assertThat(question.getUserQuestion().get(1)).isEqualTo(2);
		assertThat(question.getUserQuestion().get(2)).isEqualTo(3);
	}

	@Test
	void initUserQuestionTest() {
		question.init();
		assertThat(question.getUserQuestion().size()).isEqualTo(0);
	}
}
