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

	@Test
	public void isCorrectStrikeCount() {
		int[] com = {9, 3, 2};
		int[] user1 = {5, 3, 1};
		assertThat(getStrikeCount(com, user1)).isEqualTo(1);

		int[] user2 = {5, 2, 1};
		assertThat(getStrikeCount(com, user2)).isEqualTo(0);

		int[] user3 = {9, 3, 2};
		assertThat(getStrikeCount(com, user3)).isEqualTo(3);
	}

	@Test
	public void isCorrectBallCount() {
		int[] com = {7, 1, 3};
		int[] user1 = {1, 4, 5};
		assertThat(getBallCount(com, user1)).isEqualTo(1);

		int[] user2 = {2, 4, 6};
		assertThat(getBallCount(com, user2)).isEqualTo(0);

		int[] user3 = {3, 7, 1};
		assertThat(getBallCount(com, user3)).isEqualTo(3);
	}

}
