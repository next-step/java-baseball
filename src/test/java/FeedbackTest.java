import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FeedbackTest {
	private Feedback feedback;
	private List<Integer> answerList;
	private List<Integer> questionList;

	@BeforeEach
	void setUp() {
		feedback = new Feedback();
		answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);

		questionList = new ArrayList<>();
		questionList.add(3);
		questionList.add(2);
		questionList.add(4);
	}

	@Test
	void isSameNumberTest() {
		assertThat(feedback.isSameNumber(1, 1))
			.isEqualTo(true);
		assertThat(feedback.isSameNumber(1, 2))
			.isEqualTo(false);
	}

	@Test
	void compareSamePositionTest() {
		int result = feedback.compareSamePosition(answerList, questionList);
		assertThat(result)
			.isEqualTo(1);
	}

	@Test
	void compareDifferentPositionTest() {
		int result = feedback.compareDifferentPosition(answerList, questionList);
		assertThat(result)
			.isEqualTo(1);
	}

	@Test
	void compareTest() {
		GameResult resultDto = feedback.compare(answerList, questionList);
		assertThat(resultDto.getStrike())
			.isEqualTo(1);
		assertThat(resultDto.getBall())
			.isEqualTo(1);
	}
}
