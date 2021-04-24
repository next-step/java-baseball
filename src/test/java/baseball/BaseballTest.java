package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BaseballTest {

	@Test
	void makeAnswerNumbers() {
		Baseball baseball = new Baseball();
		baseball.makeAnswerNumbers();
		List<Integer> answerNumbers = baseball.answerNumbers;
		assertThat(answerNumbers).hasSize(3);
	}
}
