package baseball.domain;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

	@Test
	void testValidLengthText() {
		String text = "abc";
		Assert.check(Validator.isValidLength(text));

		String longerText = "abcde";
		Assert.check(!Validator.isValidLength(longerText));

		String shorterText = "ab";
		Assert.check(!Validator.isValidLength(shorterText));
	}

	@Test
	void testValidLengthNumbers() {
		int[] validNumbers = new int[] {10, 11, 12};
		Assert.check(Validator.isValidLength(validNumbers));

		int[] longerNumbers = new int[] {10, 11, 12, 13};
		Assert.check(!Validator.isValidLength(longerNumbers));

		int[] shorterNumbers = new int[] {10, 11};
		Assert.check(!Validator.isValidLength(shorterNumbers));
	}

	@Test
	void testIsInRangeNumbers() {
		int[] validRange = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.check(Validator.isInRange(validRange));

		int[] negativeNumber = new int[] {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.check(!Validator.isInRange(negativeNumber));

		int[] bigNumber = new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.check(!Validator.isInRange(bigNumber));
	}
}
