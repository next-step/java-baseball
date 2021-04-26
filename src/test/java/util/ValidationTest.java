package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ValidationTest {
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
}
