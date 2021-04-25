package baseball;

import static baseball.GameMain.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameMainTest {

	@Test
	public void hasCorrectAnswerResult() {
		int[] com = {9, 3, 2};
		int[] user1 = {9, 3, 2};
		assertThat(isAnswer(com, user1)).isTrue();

		int[] user2 = {9, 5, 2};
		assertThat(isAnswer(com, user2)).isFalse();
	}

}
