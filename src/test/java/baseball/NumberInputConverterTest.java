package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class NumberInputConverterTest {

	@Test
	void convert() {
		assertThat(NumberInputConverter.convert("123")).containsExactly(1, 2, 3);
		assertThat(NumberInputConverter.convert("415")).containsExactly(4, 1, 5);
		assertThat(NumberInputConverter.convert("267")).containsExactly(2, 6, 7);
	}

	@Test
	void convert_exception() {
		assertThatThrownBy(() -> NumberInputConverter.convert("1267"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("길이가 3이 아닙니다.");
		assertThatThrownBy(() -> NumberInputConverter.convert("111"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("1과 9 사이가 아니거나 같은 값이 존재합니다.");
		assertThatThrownBy(() -> NumberInputConverter.convert("a67"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("1과 9 사이가 아니거나 같은 값이 존재합니다.");
	}
}