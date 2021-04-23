import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionTest {
	private Question question;

	@BeforeEach
	void setUp() {
		question = new Question();
		question.setUserQuestion(1, 2, 3);
	}

	@Test
	void setUserQuestionTest() {
		question.setUserQuestion(3, 2, 1);

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
