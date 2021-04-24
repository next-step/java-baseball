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
		assertThatCode(() -> {
			baseballUtils.checkEqualLength3(answer);
		}).doesNotThrowAnyException();
		assertThatCode(() -> {
			baseballUtils.checkNotExistsDupNumbers(answer);
		}).doesNotThrowAnyException();
	}

	@Test
	public void isEqualLength3Test() {
		// gevin
		// when

		// then
		assertThatCode(() -> {
				baseballUtils.checkEqualLength3("123");
			}).doesNotThrowAnyException();
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkEqualLength3("12");
			}).withMessageContaining("3자리 숫자를 입력해주세요!");
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkEqualLength3("1234");
			}).withMessageContaining("3자리 숫자를 입력해주세요!");
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkEqualLength3(null);
			}).withMessageContaining("3자리 숫자를 입력해주세요!");

	}

	@Test
	public void checkNumberTypeTest() {
		// given
		// when
		// then
		assertThatCode(() -> {
				baseballUtils.checkNumberType("123");
			}).doesNotThrowAnyException();

		assertThatCode(() -> {
				baseballUtils.checkNumberType("369");
			}).doesNotThrowAnyException();

		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNumberType("123a");
			}).withMessageContaining("숫자만 입력해주세요!");


		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNumberType("!2345");
			}).withMessageContaining("숫자만 입력해주세요!");

		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNumberType("한글테스트");
			}).withMessageContaining("숫자만 입력해주세요!");
	}

	@Test
	public void checkIncludeZeroTest(){
		// given
		// when
		// then
		assertThatCode(() -> {
			baseballUtils.checkIncludeZero("123");
		}).doesNotThrowAnyException();

		assertThatCode(() -> {
			baseballUtils.checkIncludeZero("369");
		}).doesNotThrowAnyException();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			baseballUtils.checkIncludeZero("890");
		}).withMessageContaining("0을 제외한 1부터 9까지 숫자를 입력해주세요!");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			baseballUtils.checkIncludeZero("017");
		}).withMessageContaining("0을 제외한 1부터 9까지 숫자를 입력해주세요!");

	}

	@Test
	public void isNotExistsDupNumbers() {
		// gevin
		// when

		// then
		assertThatCode(() -> {
				baseballUtils.checkNotExistsDupNumbers("123");
			}).doesNotThrowAnyException();

		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNotExistsDupNumbers("112");
			}).withMessageContaining("중복되는 숫자 없이 입력해주세요!");
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNotExistsDupNumbers("122");
			}).withMessageContaining("중복되는 숫자 없이 입력해주세요!");
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNotExistsDupNumbers("353");
			}).withMessageContaining("중복되는 숫자 없이 입력해주세요!");
		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseballUtils.checkNotExistsDupNumbers("1231");
			}).withMessageContaining("중복되는 숫자 없이 입력해주세요!");
		assertThatCode(() -> {
				baseballUtils.checkNotExistsDupNumbers("1234");
			}).doesNotThrowAnyException();
	}

}
