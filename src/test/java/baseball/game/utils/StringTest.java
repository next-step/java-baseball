/*
 * @(#) StringTest.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 박준영
 **/
public class StringTest {

	@Test
	@DisplayName("요구사항1 split 테스트")
	void splitString() {
		String[] split = "1,2".split(",");
		Assertions.assertThat(split.length).isEqualTo(2);
		Assertions.assertThat(split).containsExactly("1", "2");

		split = "1".split(",");
		Assertions.assertThat(split.length).isEqualTo(1);
		Assertions.assertThat(split).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항2, subString 테스트")
	void subString() {
		String value = "(1,2)";
		Assertions.assertThat(value.substring(1, value.length() -1)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항3 charAt 위치 벗어나면 StringIndexOutOfBoundsException")
	void charAt() {
		String value = "abc";
		Assertions.assertThat(value.charAt(0)).isEqualTo('a');
		Assertions.assertThat(value.charAt(1)).isEqualTo('b');
		Assertions.assertThat(value.charAt(2)).isEqualTo('c');

		Assertions.assertThatThrownBy(() ->value.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range: 3");

	}
}
