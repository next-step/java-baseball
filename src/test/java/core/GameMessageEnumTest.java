package core;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Description : Game Message Enum Test
 *
 * Created by jychoi on 2021/04/27.
 */
class GameMessageEnumTest {

	@Test
	@DisplayName("스트라이크만 있는 경우의 메시지 출력")
	void getCurrentResultMessageOnlyStrike() {
		String given = "1 스트라이크";
		AnswerObject when = new AnswerObject(1, 0);
		assertThat(given).isEqualTo(GameMessageEnum.getCurrentResultMessage(when));
	}

	@Test
	@DisplayName("볼만 있는 경우의 메시지 출력")
	void getCurrentResultMessageOnlyBall() {
		String given = "3 볼";
		AnswerObject when = new AnswerObject(0, 3);
		assertThat(given).isEqualTo(GameMessageEnum.getCurrentResultMessage(when));
	}

	@Test
	@DisplayName("포볼인 경우의 메시지 출력")
	void getCurrentResultMessage4Ball() {
		String given = "포볼";
		AnswerObject when = new AnswerObject(0, 0);
		assertThat(given).isEqualTo(GameMessageEnum.getCurrentResultMessage(when));
	}

	@Test
	@DisplayName("일반적인 경우의 메시지 출력")
	void getCurrentResultMessage() {
		String given = "2 스트라이크 1 볼";
		AnswerObject when = new AnswerObject(2, 1);
		assertThat(given).isEqualTo(GameMessageEnum.getCurrentResultMessage(when));
	}
}