package baseball.answer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.AppConfig;

class AnswerServiceTest {

	AnswerService answerService;
	public final int BASEBALL_ANSWER_SIZE = 3;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		answerService = appConfig.answerService();
	}

	@Test
	@DisplayName("컴퓨터가 저장하는 정답이 서로다른 숫자 3개인지 확인")
	void buildAnswer() {
		List<Integer> answer = answerService.buildAnswer();
		HashSet<Integer> answerSet = new HashSet<>(answer);

		assertThat(answer.size())
			.isEqualTo(BASEBALL_ANSWER_SIZE)
			.isEqualTo(answerSet.size());
	}

}
