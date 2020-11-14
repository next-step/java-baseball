import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

	@Test
	public void BaseballNumber_MaxSize_초과시에러() {
		BaseballGame baseballGame = new BaseballGame();
		String[] numbers = "1234".split("");
		assertThrows(RuntimeException.class, () -> {
			baseballGame.checkValid(numbers);
		});
	}
}
