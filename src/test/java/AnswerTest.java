import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AnswerTest {
	private Answer answer = new Answer();

	@Test
	void generateRandomNumberSizeTest() {
		assertThat(answer.generateRandomNumber().size())
			.isEqualTo(3);
	}

	@Test
	void generateRandomNumberDifferenceTest() {
		List<Integer> answerList = answer.generateRandomNumber();
		assertThat(answerList.get(0)).isNotEqualTo(answerList.get(1));
		assertThat(answerList.get(0)).isNotEqualTo(answerList.get(2));
		assertThat(answerList.get(1)).isNotEqualTo(answerList.get(2));
	}
}
