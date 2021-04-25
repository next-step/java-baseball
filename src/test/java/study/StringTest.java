package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    void split() {
		assertThat("1,2".split(",")).contains("1").contains("2");
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	void substring() {
		assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
	}

	@Test
	void charAt() {
		assertThat("abc".charAt(0)).isEqualTo('a');
		assertThat("abc".charAt(1)).isEqualTo('b');
		assertThat("abc".charAt(2)).isEqualTo('c');
		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");
	}
}
