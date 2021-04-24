import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballUtilsTest {

	BaseballUtils baseballUtils = new BaseballUtils();

	@Test
	public void cerateAnswerTest() {
		// given
		baseballUtils = new BaseballUtils();

		// when
		final String answer = baseballUtils.cerateAnswer();

		// then
		assertThat(baseballUtils.isEqualLength3(answer)).isTrue();
		assertThat(baseballUtils.isNotExistsDupNumbers(answer)).isTrue();
	}

	@Test
	public void isEqualLength3Test() {
		// gevin
		// when
		String testStr1 = "123";
		String testStr2 = "12";
		String testStr3 = "1234";
		String testStr4 = null;

		// then
		assertThat(baseballUtils.isEqualLength3(testStr1)).isTrue();
		assertThat(baseballUtils.isEqualLength3(testStr2)).isFalse();
		assertThat(baseballUtils.isEqualLength3(testStr3)).isFalse();
		assertThat(baseballUtils.isEqualLength3(testStr4)).isFalse();

	}

	@Test
	public void isNotExistsDupNumbers() {
		// gevin
		// when
		String testStr1 = "123";
		String testStr2 = "112";
		String testStr3 = "122";
		String testStr4 = "353";
		String testStr5 = "1231";
		String testStr6 = "1234";

		// then
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr1)).isTrue();
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr2)).isFalse();
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr3)).isFalse();
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr4)).isFalse();
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr5)).isFalse();
		assertThat(baseballUtils.isNotExistsDupNumbers(testStr6)).isTrue();
	}

}
