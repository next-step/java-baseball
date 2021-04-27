package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.JavaBaseBallGame;

public class JavaBaseBallGameTest {
	JavaBaseBallGame game = new JavaBaseBallGame();

	@Test
	@DisplayName("�ߺ����� �ʴ� 3�ڸ��� ���ڰ� �����Ǵ��� Ȯ���Ѵ�.")
	void setAnswerNumberTest() {
		game.setAnswerNumber();
		
		assertThat(game.answerNumber)
			.hasSize(3)
			.doesNotHaveDuplicates();
	}
	
	@Test
	@DisplayName("strike�� ball���� �´��� Ȯ���Ѵ�.")
	void countUserNumberTest() {
		game.userNumber = new JavaBaseBallUserNumber();
		game.gameCount = new JavaBaseBallCount();
		game.userNumber.userNumber = Arrays.asList(1, 2, 3);
		game.answerNumber = Arrays.asList(1, 4, 2);
		game.countUserNumber();
		
		assertThat(game.gameCount)
			.extracting("ballCount", "strikeCount")
			.containsExactly(1, 1);
	}
}
