package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	@DisplayName("요구사항1 \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는 지 확인하는 학습 테스트")
	public void splitContains() {
		// given
		String str = "1,2";

		// when
		String[] splitStr = str.split(",");

		// then
		assertThat(splitStr).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항1 \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
	public void splitContainsExactly() {
		// given
		String str = "1";

		// when
		String[] splitStr = str.split(",");

		// then
		assertThat(splitStr).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항2 \"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용하여 ()을 제거하고 \"1,2\"를 반환")
	public void subString() {
		// given
		String str = "(1,2)";

		// when
		String subString = str.substring(1, 4);

		// then
		assertThat(subString).isEqualTo("1,2");
	}

	@Test
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
	public void chatAt() {
		// given
		String str = "abc";

		// when
		char ch = str.charAt(0);

		// then
		assertThat(ch).isEqualTo('a');
	}

	@Test
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치값이 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
	public void indexOutOfBoundsException() {
		// given
		String str = "abc";

		// then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> str.charAt(3))
			.withMessageMatching("String index out of range: 3");

	}

}
