package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class NumberInputConverterTest {

	@Test
	void toNumbers() {
		assertThat(NumberInputConverter.toNumbers("123")).containsExactly(1, 2, 3);
		assertThat(NumberInputConverter.toNumbers("415")).containsExactly(4, 1, 5);
		assertThat(NumberInputConverter.toNumbers("267")).containsExactly(2, 6, 7);
	}

	@Test
	void toNumbers_exception() {
		assertThatThrownBy(() -> NumberInputConverter.toNumbers("1267"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("길이가 3이 아닙니다.");
		assertThatThrownBy(() -> NumberInputConverter.toNumbers("111"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("1과 9 사이가 아니거나 같은 값이 존재합니다.");
		assertThatThrownBy(() -> NumberInputConverter.toNumbers("a67"))
			.isInstanceOf(WrongNumberInputException.class)
			.hasMessageContaining("1과 9 사이가 아니거나 같은 값이 존재합니다.");
	}
}