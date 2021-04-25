package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void string_split_test1_1() {
		String str = "1,2";

		String[] result = str.split(",");

		assertThat(result).contains("1", "2");
	}

	@Test
	void string_split_test1_2() {
		String str = "1";

		String[] result = str.split(",");

		assertThat(result).containsExactly("1");
	}

	@Test
	void string_substring_test2() {
		String str = "(1,2)";

		String result = str.substring(1, 4);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 인덱스 1을 호출할 때")
	void string_charAt_test3_1() {
		String str = "abc";

		char result = str.charAt(1);

		assertThat(result).isEqualTo('b');
	}

	@Test
	@DisplayName("charAt 인덱스 범위를 넘어서 호출할 때, indexOutOfBoundsException 발생")
	void string_charAt_test3_2() {
		String str = "abc";

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> str.charAt(4));
	}
}
