package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RefereeTest {

	Referee referee = new Referee();

	@Test
	void strike() {
		int[] arr = {1, 2, 3};

		assertThat(referee.countStrikes(arr, new int[] {-1, -1, -1})).isEqualTo(0);

		assertThat(referee.countStrikes(arr, new int[] {1, -1, -1})).isEqualTo(1);
		assertThat(referee.countStrikes(arr, new int[] {-1, 2, -1})).isEqualTo(1);
		assertThat(referee.countStrikes(arr, new int[] {-1, -1, 3})).isEqualTo(1);

		assertThat(referee.countStrikes(arr, new int[] {1, 2, -1})).isEqualTo(2);
		assertThat(referee.countStrikes(arr, new int[] {-1, 2, 3})).isEqualTo(2);
		assertThat(referee.countStrikes(arr, new int[] {1, -1, 3})).isEqualTo(2);

		assertThat(referee.countStrikes(arr, new int[] {1, 2, 3})).isEqualTo(3);
	}

	@Test
	void ball() {
		int[] arr = {1, 2, 3};

		assertThat(referee.countBall(arr, new int[] {-1, -1, -1})).isEqualTo(0);
		assertThat(referee.countBall(arr, new int[] {1, 2, 3})).isEqualTo(0);

		assertThat(referee.countBall(arr, new int[] {-1, 1, -1})).isEqualTo(1);
		assertThat(referee.countBall(arr, new int[] {-1, -1, 1})).isEqualTo(1);

		assertThat(referee.countBall(arr, new int[] {1, 1, 1})).isEqualTo(2);
		assertThat(referee.countBall(arr, new int[] {2, 2, 2})).isEqualTo(2);
		assertThat(referee.countBall(arr, new int[] {3, 3, 3})).isEqualTo(2);

		assertThat(referee.countBall(arr, new int[] {3, 1, 2})).isEqualTo(3);
		assertThat(referee.countBall(arr, new int[] {2, 3, 1})).isEqualTo(3);
	}

	@Test
	void answer() {
		int[] arr = {1, 2, 3};
		assertThat(referee.isAnswer(referee.countStrikes(arr, new int[] {1, 2, 3}))).isTrue();

	}

	@Test
	void notAnswer() {
		int[] arr = {1, 2, 3};

		assertThat(referee.isAnswer(referee.countStrikes(arr, new int[] {1, 3, 2}))).isFalse();
		assertThat(referee.isAnswer(referee.countStrikes(arr, new int[] {3, 2, 1}))).isFalse();
		assertThat(referee.isAnswer(referee.countStrikes(arr, new int[] {1, 2, -1}))).isFalse();
	}

	@Test
	void nothing() {
		int strikes = 0;
		int balls = 0;

		int[] arr = {1, 2, 3};

		int[] cmp1 = {1, 2, 3};
		strikes = referee.countStrikes(arr, cmp1);
		balls = referee.countStrikes(arr, cmp1);
		assertThat(referee.isNothing(strikes, balls)).isFalse();

		int[] cmp2 = {1, -1, -1};
		strikes = referee.countStrikes(arr, cmp2);
		balls = referee.countStrikes(arr, cmp2);
		assertThat(referee.isNothing(strikes, balls)).isFalse();

		int[] cmp3 = {-1, -1, -1};
		strikes = referee.countStrikes(arr, cmp3);
		balls = referee.countStrikes(arr, cmp3);
		assertThat(referee.isNothing(strikes, balls)).isTrue();
	}

}
