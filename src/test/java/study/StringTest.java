package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
	@Test
	@DisplayName("요구사항 1 - split test")
	void contains() {
		String[] values = "1,2".split(",");

		assertThat(values).contains("1", "2");
		assertThat(values).contains("2", "1");
		assertThat(values).containsExactly("1", "2");

		values = "1".split(",");

		assertThat(values).contains("1");
		assertThat(values).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2 - substring test")
	void equals() {
		String value = "(1,2)";
		value = value.substring(1, value.length() - 1);

		assertEquals(value, "1,2");
		assertThat(value).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항 3 - charAt test")
	void thrown() {
		String value = "abc";

		assertThat(value.charAt(0)).isEqualTo('a');
		assertThat(value.charAt(1)).isEqualTo('b');
		assertThat(value.charAt(2)).isEqualTo('c');

		ThrowableAssert.ThrowingCallable callable = () -> System.out.println(value.charAt(3));

		assertThatThrownBy(callable)
				.isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 3");

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(callable)
				.withMessageMatching("String index out of range: \\d+");
	}
}
