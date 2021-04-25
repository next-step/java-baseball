package javabaseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberStringGeneratorTest {

	@DisplayName("길이를 인자로 받아 해당 길이만큼 생성")
	@Test
	void generate_shouldGenerateTheExpectedLength() {
		// given
		int length = 3;
		RandomNumberStringGenerator randomNumberStringGenerator = new RandomNumberStringGenerator();

		// when
		String randomNumberString = randomNumberStringGenerator.generate(length);

		// then
		assertEquals(length, randomNumberString.length());
	}

	@DisplayName("각 자리의 숫자는 중복되지 않은 1 ~ 9 숫자로 구성")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void generate_shouldIncludedExpectedNumberRange(int number) {
		// given
		int length = 9;
		RandomNumberStringGenerator randomNumberStringGenerator = new RandomNumberStringGenerator();

		// when
		String randomNumberString = randomNumberStringGenerator.generate(length);

		// then
		assertFalse(randomNumberString.contains("0"));
		assertTrue(randomNumberString.contains(String.valueOf(number)));
	}

	@DisplayName("중복되지 않게 10자리 이상의 숫자를 만들수 없음")
	@Test()
	void generate_shouldThrowException() {
		// given
		int length = 10;
		RandomNumberStringGenerator randomNumberStringGenerator = new RandomNumberStringGenerator();

		// when & then
		// 1 ~ 9 의 숫자는 한 번씩만 사용 가능하기 때문에 10자리 이상의 숫자를 만들 수 없다.
		assertThatIllegalArgumentException().isThrownBy(() -> randomNumberStringGenerator.generate(length));
	}

}