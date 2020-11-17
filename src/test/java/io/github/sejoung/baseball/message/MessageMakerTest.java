package io.github.sejoung.baseball.message;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageMakerTest {

	@DisplayName("스트라이크 메시지")
	@Test
	void strikeMessage() {
		int strikeCount = 1;
		String result = MessageMaker.getPlayMessage(strikeCount, 0);
		assertThat(result).isEqualTo(String.format("%d 스트라이크 ", strikeCount));
	}

	@DisplayName("스트라이크 볼 메시지")
	@Test
	void strikeAndBallMessage() {
		int strikeCount = 1;
		int ballCount = 2;
		String result = MessageMaker.getPlayMessage(strikeCount, ballCount);
		assertThat(result).isEqualTo(String.format("%d 스트라이크 %d 볼", strikeCount, ballCount));
	}

	@DisplayName("낫싱 메시지")
	@Test
	void notThingMessage() {
		int strikeCount = 0;
		int ballCount = 0;
		String result = MessageMaker.getPlayMessage(strikeCount, ballCount);
		assertThat(result).isEqualTo("낫싱");
	}

	@DisplayName("볼 메시지")
	@Test
	void ballMessage() {
		int strikeCount = 0;
		int ballCount = 2;
		String result = MessageMaker.getPlayMessage(strikeCount, ballCount);
		assertThat(result).isEqualTo(String.format("%d 볼", ballCount));
	}

	@DisplayName("3 스트라이크 메시지")
	@Test
	void endGameMessage() {
		int strikeCount = 3;
		int ballCount = 0;
		String result = MessageMaker.getPlayMessage(strikeCount, ballCount);
		assertThat(result).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1,종료 하려면 2를 입력하세요.");
	}

}
