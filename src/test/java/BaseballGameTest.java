import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

	BaseballGame baseballGame = new BaseballGame();
	BaseballUtils baseballUtils = new BaseballUtils();

	@Test
	public void initGameTest() {
		// given
		baseballGame.initGame();

		// when
		String answer = baseballGame.getAnswer();

		// then
		assertThat(baseballUtils.isEqualLength3(answer)).isTrue();
		assertThat(baseballUtils.isNotExistsDupNumbers(answer)).isTrue();

	}

}
