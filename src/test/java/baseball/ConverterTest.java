package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConverterTest {

	Converter converter = new Converter();

	@Test
	void isThreeDigits() {
		assertThat(converter.isThreeDigits("100")).isTrue();
		assertThat(converter.isThreeDigits("999")).isTrue();

		assertThat(converter.isThreeDigits("000")).isFalse();
		assertThat(converter.isThreeDigits("099")).isFalse();
		assertThat(converter.isThreeDigits("1000")).isFalse();
	}

	@Test
	void toNumber() {
		assertThat(converter.toNumber("123")).isEqualTo(123);
	}

	@Test
	void isNumber() {
		assertThat(converter.isNumber("123")).isTrue();
		assertThat(converter.isNumber("text")).isFalse();
		assertThat(converter.isNumber("")).isFalse();
	}

	@Test
	void toArray() {
		assertThat(converter.toArray(123)).isEqualTo(new int[] {1, 2, 3});
		assertThat(converter.toArray(456)).isEqualTo(new int[] {4, 5, 6});
	}
}
