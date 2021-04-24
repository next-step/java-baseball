import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.Numbers;


class RandomNumbersGeneratorTest {

	static class MockRandom extends Random {
		private final String mockRandomNumbers;
		private int nextIntCallCount;

		MockRandom(String mockRandomNumbers) {
			this.mockRandomNumbers = mockRandomNumbers;
			this.nextIntCallCount = 0;
		}

		@Override
		public int nextInt(int bound) {
			char[] randomNumberChars = mockRandomNumbers.toCharArray();
			int idx = nextIntCallCount++ % Numbers.LENGTH;
			return Character.digit(randomNumberChars[idx], Numbers.NUMBER_RADIX) - 1;
		}
	}

	@Test
	@DisplayName("주입된 Random 객체 기반으로 3개의 숫자를 생성해야 한다.")
	public void generateNumbersTest() {
		//given
		String inputNumbers = "123";
		MockRandom mockRandom = new MockRandom(inputNumbers);
		RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(mockRandom);

		//when
		Numbers numbers = randomNumbersGenerator.generate();

		//then
		assertThat(numbers).isEqualTo(Numbers.of(inputNumbers));
	}

}
