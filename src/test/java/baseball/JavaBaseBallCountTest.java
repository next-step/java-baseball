package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.JavaBaseBallGame;

public class JavaBaseBallCountTest {
	JavaBaseBallGame game = new JavaBaseBallGame();

	@Test
	@DisplayName("strike�� ball ī��Ʈ�� ���µǴ��� Ȯ���Ѵ�.")
	public void resetCountTest() {
		game.userNumber = new JavaBaseBallUserNumber();
		game.gameCount = new JavaBaseBallCount();
		
		game.gameCount.strikeCount = 1;
		game.gameCount.ballCount = 2;
		
		game.gameCount.resetCount();
		
		assertThat(game.gameCount)
		.extracting("ballCount", "strikeCount")
		.containsExactly(0, 0);
	}
}
