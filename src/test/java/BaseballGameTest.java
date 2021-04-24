import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

	BaseballConsole console = new BaseballConsole();
	BaseballGame baseballGame = new BaseballGame(console);
	BaseballUtils baseballUtils = new BaseballUtils();

	@Test
	public void initGameTest() {
		// given
		baseballGame.initGame();

		// when
		String answer = baseballGame.getAnswer();

		// then
		assertThatCode(() -> {
			baseballUtils.checkEqualLength3(answer);
		}).doesNotThrowAnyException();
		assertThatCode(() -> {
			baseballUtils.checkNotExistsDupNumbers(answer);
		}).doesNotThrowAnyException();

	}

}
