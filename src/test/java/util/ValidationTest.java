package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ValidationTest {
	@Test
	public void isValidAnswerTest() {
		boolean validUserAnswer = Validation.isValidAnswer("123");
		boolean invalidUserAnswer1 = Validation.isValidAnswer("1234");
		boolean invalidUserAnswer2 = Validation.isValidAnswer("112");
		boolean invalidUserAnswer3 = Validation.isValidAnswer("403");
		boolean invalidUserAnswer4 = Validation.isValidAnswer("xyz");
		assertThat(validUserAnswer).isTrue();
		assertThat(invalidUserAnswer1).isFalse();
		assertThat(invalidUserAnswer2).isFalse();
		assertThat(invalidUserAnswer3).isFalse();
		assertThat(invalidUserAnswer4).isFalse();
	}

	@Test
	public void isNumericTest() {
		boolean numericValue = Validation.isNumeric("123456789");
		boolean noneNumericValue = Validation.isNumeric("가나다123");
		assertThat(numericValue).isTrue();
		assertThat(noneNumericValue).isFalse();
	}

	@Test
	public void isDuplicatedTest() {
		boolean duplicatedValue = Validation.isDuplicated("1123953");
		boolean notDuplicatedValue = Validation.isDuplicated("123456789");
		assertThat(duplicatedValue).isTrue();
		assertThat(notDuplicatedValue).isFalse();
	}

	@Test
	public void isValidToRestartTest() {
		boolean validToRestart1 = Validation.isValidToRestart("1");
		boolean validToRestart2 = Validation.isValidToRestart("2");
		boolean invalidToRestart1 = Validation.isValidToRestart("123456789");
		boolean invalidToRestart2 = Validation.isValidToRestart("abc");
		boolean invalidToRestart3 = Validation.isValidToRestart("X");
		assertThat(validToRestart1).isTrue();
		assertThat(validToRestart2).isTrue();
		assertThat(invalidToRestart1).isFalse();
		assertThat(invalidToRestart2).isFalse();
		assertThat(invalidToRestart3).isFalse();
	}
}
