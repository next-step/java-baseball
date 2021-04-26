package baseball.question;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.AppConfig;

class QuestionServiceImplTest {

	QuestionService questionService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		questionService = appConfig.questionService();
	}

	@Test
	@DisplayName("정답을 맞추기 위해 질문을 입력받는다. 입력받은 글자가 3글자를 초과하면 3글자로 자른다.")
	void inputQuestionTest() {
		String input = "1234";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		List<String> inputQuestion = questionService.inputQuestion();

		assertThat(inputQuestion.size())
			.isLessThanOrEqualTo(3);
	}
}
