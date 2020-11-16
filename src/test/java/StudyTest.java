import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudyTest {
	@Test
	void splitComma_isOk_manyValue() {
		String originString = "1,2";
		String[] splitString = originString.split(",");

		assertThat(splitString)
				.isNotEmpty()
				.contains("1")
				.contains("2");

		assertThat(splitString)
				.isNotEmpty()
				.containsExactly("1", "2");
	}

	@Test
	void splitComma_isOk_oneValue() {
		String originString = "1";
		String[] splitString = originString.split(",");

		assertThat(splitString)
				.isNotEmpty()
				.contains("1");

		assertThat(splitString)
				.isNotEmpty()
				.containsExactly("1");
	}

	@Test
	void substring_isOk() {
		String originString = "(1,2)";
		String substringString = originString.substring(
				originString.indexOf("(") + 1,
				originString.indexOf(")"));

		assertEquals(substringString, "1,2");
	}

	@Test
	@DisplayName("기본이 되는 문자열로부터 index를 사용하여 특정 위치의 문자 가져오기")
	void getCharFromString_isOk() {
		String originString = "abc";
		char[] compareCharArray = {'a', 'b', 'c'};
		int originStringLength = originString.length();

		for (int i = 0; i < originStringLength; i++) {
			assertEquals(originString.charAt(i), compareCharArray[i]);
		}
	}

	@Test
	@DisplayName("기본이 되는 문자열로부터 index를 사용하여 특정 위치의 문자 가져오던 중 실패")
	void getCharFromString_isIndexOutOfBounds() {
		String originString = "abc";

		assertThatThrownBy(() -> {
			char tempChar = originString.charAt(originString.length() + 1);
		})
		.isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range: 4");

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> {
			char tempChar = originString.charAt(originString.length() + 1);
		})
		.withMessageMatching("String index out of range: \\d+");
	}
}
