package exam.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessagePrinterTest {

	@Test
	void testMakeHint() {
		BaseballGame game = new BaseballGame(null);
		assertThat(game.makeHint(new Score(0, 0))).isEqualTo("낫싱");
		assertThat(game.makeHint(new Score(1, 2))).isEqualTo("1 스트라이크 2 볼");
		assertThat(game.makeHint(new Score(3, 0))).isEqualTo("3 스트라이크");
		assertThat(game.makeHint(new Score(0, 2))).isEqualTo("2 볼");
	}

}
