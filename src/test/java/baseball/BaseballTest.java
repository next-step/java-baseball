package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BaseballTest {

	@Test
	void makeAnswerNumbers() {
		Baseball baseball = new Baseball();
		baseball.makeAnswerNumbers();
		List<Integer> answerNumbers = baseball.answerNumbers;
		assertThat(answerNumbers).hasSize(3);

		HashSet<Integer> uniqueSet = new HashSet<>(answerNumbers);
		assertThat(uniqueSet).hasSize(3);

		for(Integer number: answerNumbers) {
			assertThat(number).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
		}
	}
}
