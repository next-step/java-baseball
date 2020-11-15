package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.CustomException;

class BaseballGameTest {

	@Test
	public void BaseballNumber_MaxSize_초과시에러() {
		BaseballGame baseballGame = new BaseballGame();
		String[] numbers = "1234".split("");
		assertThrows(CustomException.BaseballNumberExceedSizeException.class, () -> {
			baseballGame.checkLengthOver(numbers);
		});
	}

	@Test
	public void BaseballNumber_중복숙자인입시에러() {
		BaseballGame baseballGame = new BaseballGame();
		String[] numbers = "113".split("");
		assertThrows(CustomException.BaseballNumberDuplicatedException.class, () -> {
			baseballGame.checkDuplicated(numbers);
		});
	}
}
