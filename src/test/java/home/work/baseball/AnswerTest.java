package home.work.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

	@Test
	final void testIncreaseStrike() {
		int count = 2;
		Answer answer = new Answer();
		for (int i = 0; i < count; i++) {
			answer.increaseStrike();
		}
		assertThat(answer.getStrike()).isEqualTo(count);
	}

	@Test
	final void testIncreaseBall() {
		int count = 3;
		Answer answer = new Answer();
		for (int i = 0; i < count; i++) {
			answer.increaseBall();
		}
		assertThat(answer.getBall()).isEqualTo(count);
	}

	@Test
	@DisplayName("낫싱 출력 테스트")
	final void testPrintNothing() {
		Answer answer = new Answer();
		assertThat(answer.print()).isEqualTo("낫싱");
	}
	
	@Test
	@DisplayName("스트라이크, 볼 출력 테스트")
	final void testPrintStrikeAndBall() {
		int strikeCount = 1;
		int ballCount = 2;
		Answer answer = new Answer();
		for (int i = 0; i < strikeCount; i++) {
			answer.increaseStrike();
		}
		for (int i = 0; i < ballCount; i++) {
			answer.increaseBall();
		}
		assertThat(answer.print()).isEqualTo(strikeCount + " 스트라이크 " + ballCount + "볼");
	}

}
