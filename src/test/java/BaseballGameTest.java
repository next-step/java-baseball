import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;

public class BaseballGameTest {

	@Test
	public void createGameReturnQuestions() {
		// Arrange
		BaseballGame game = new BaseballGame();
		// Act
		game.startGame();

		// Assert

		// 1. 값이 NULL이 아닌지 Check
		assertThat(game.getQuestion())
			.isNotEmpty()
			.isNotNull();

		// 2. 숫자 뽑은 숫자의 개수가 3개가 맞는지?
		assertThat(game.getQuestion().size()).isEqualTo(3);

		// 3. 각각의 숫자가 정상적인 범위에 들어가 있는지?
		Iterator<Integer> iter = game.getQuestion().iterator();
		for(int i = 0; i < 3; i++) {
			iter.hasNext();
			assertThat(iter.next()).isBetween(1, 9);
		}
	}

	@Test
	public void addAnswersTest() {
		BaseballGame game = new BaseballGame();
		String[] test = {"1", "2", "3"};

		game.addAnswers(test);

		Iterator<Integer> iter = game.getQuestion().iterator();

		while(iter.hasNext()) {
			int i = 0;
			assertThat(iter.next()).isEqualTo(test[i++]);
		}
	}

	@Test
	public void doCheckStrikeAndBallTest() {
		BaseballGame game = new BaseballGame();

		game.addAnswers(new String[] {"1", "2", "3"});

		assertThat(game.decideAnswers()).isFalse();
	}
}
