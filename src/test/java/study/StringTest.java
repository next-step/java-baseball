package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void stringSplitTest() {
		assertThat(stringSplit("1,2")).contains("1", "2");
		assertThat(stringSplit("1")).containsExactly("1");
	}

	@Test
	void stringSubstringTest() {
		assertThat(stringSubstring("(1,2)")).isEqualTo("1,2");
	}

	@Test
	@DisplayName("Testing Exception of chatAt method when StringIndexOutOfBoundsException happens")
	void stringChatAtTest() {
		assertThat(stringCharAt("abc", 0)).isEqualTo('a');
		assertThat(stringCharAt("abc", 1)).isEqualTo('b');
		assertThat(stringCharAt("abc", 2)).isEqualTo('c');

		assertThatThrownBy(() -> {
			stringCharAt("abc", 4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range:");
	}

	private String[] stringSplit(String inputString) {
		return inputString.split(",");
	}

	private String stringSubstring(String inputString) {
		return inputString.substring(1, 4);
	}

	private Character stringCharAt(String inputString, int position) {
		return inputString.charAt(position);
	}

}
