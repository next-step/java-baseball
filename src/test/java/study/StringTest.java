package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
	@Test
	@DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	void splitTest() {
		// given
		String actual = "1,2";

		// when
		String[] splitString = actual.split(",");

		// then
		assertThat(splitString).containsExactly("1", "2");
	}

	@Test
	@DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다")
	void splitTest2() {
		// given
		String actual = "1";

		// when
		String[] splitString = actual.split(",");

		// then
		assertThat(splitString).containsExactly("1");
	}

	@Test
	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환 하도록 구현한다")
	void substringTest() {
		// given
		String actual = "(1,2)";

		// when
		String substringActual = actual.substring(1, 4);

		// then
		assertThat(substringActual).isEqualTo("1,2");
	}

	@Test
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다")
	void charAtTest() {
		// given
		String actual = "abc";

		// when
		char a = actual.charAt(0);
		char b = actual.charAt(1);
		char c = actual.charAt(2);

		// then
		assertThat(a).isEqualTo('a');
		assertThat(b).isEqualTo('b');
		assertThat(c).isEqualTo('c');
	}

	@Test
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다")
	void charAtExceptionTest() {
		// given
		String actual = "abc";

		// when, then
		assertThatThrownBy(() -> actual.charAt(3))
				.isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 3");

	}
}
