package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("1,2를 ,로 split 하면, String 배열로 분리되고 배열은 1, 2를 포함하여야 한다")
	void arrayShouldBeContain1and2WhenItIsSplitByComma() {
		// given
		String input = "1,2";

		// when
		String[] result = input.split(",");

		// then
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("문자열에 없는 값으로 split 하면, 문자열은 그대로 배열로 변환된다")
	void stringIsGoingToBeArrayWhenStringDoesntContainSplitChar() {
		// given
		String input = "1";

		// when
		String[] result = input.split(",");

		// then
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("substring 을 사용하여, 문자열을 잘라낼 수 있다")
	void canMakeSubstringUsingStringIndex() {
		// given
		String input = "(1,2)";

		// when
		String result = input.substring(1, 4);

		// then
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 을 사용하여, 문자열로부터 문자를 추출할 수 있다.")
	void canGetCharUsingCharAt() {
		// given
		String input = "abc";

		// when
		char result = input.charAt(0);

		// then
		assertThat(result).isEqualTo('a');
	}

	@Test
	@DisplayName("Index 밖의 값을 chatAt 으로 가져오려고 하면, IndexOutOfBoundsException 이 발생한다")
	void throwExceptionOnTryingToGetCharOutOfIndex() {
		// given
		String input = "abc";

		// when
		assertThatThrownBy(() -> input.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");

		// then
	}
}
