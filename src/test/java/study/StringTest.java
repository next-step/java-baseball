package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	@DisplayName("Spring split 메소드")
	public void split() {
		//Given
		String text = "1,2";

		//When
		String[] result = text.split(",");

		//Then
		assertThat(result).contains("1").contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("Spring substring 메소드")
	public void substring() {
		//Given
		String text = "(1,2)";

		//When
		String actual = text.substring(1, text.length() - 1);

		//Then
		assertThat(actual).isEqualTo("1,2");
	}

	@ParameterizedTest
	@DisplayName("Spring charAt 메소드")
	@CsvSource({"a,0", "b,1", "c,2"})
	public void charAt1(char expected, int index) {
		//Given
		String text = "abc";

		//Then
		assertThat(text.charAt(index))
			.isEqualTo(expected)
			.inUnicode()
			.isLowerCase();
	}

	@Test
	@DisplayName("String charAt 인덱스 범위를 벗어나는 경우")
	public void charAt2() {
		//Given
		String text = "abc";

		//Then
		assertThatThrownBy(() -> text.charAt(3))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("index out of range");
	}
}
