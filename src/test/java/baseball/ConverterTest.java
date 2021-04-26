package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterTest {

	@DisplayName("문자열 -> 숫자 변환")
	@Test
	void toNumber() {
		assertThat(Converter.toNumber("123")).isEqualTo(123);
	}

	@DisplayName("문자열 -> 숫자 변환 가능")
	@ParameterizedTest
	@ValueSource(strings = {"123"})
	void isNumber(String str) {
		assertThat(Converter.isNumber(str)).isTrue();
	}

	@DisplayName("문자열 -> 숫자 변환 불가")
	@ParameterizedTest
	@ValueSource(strings = {"text", ""})
	void notNumber(String str) {
		assertThat(Converter.isNumber(str)).isFalse();
	}

	@DisplayName("숫자 -> 숫자 리스트")
	@Test
	void toList() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		assertThat(Converter.toList(123)).isEqualTo(list);
	}
}
