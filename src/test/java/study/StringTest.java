package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@Test
	@DisplayName("\"1\" ,\"2\" 을 , 로 split 했을 때 \"1\" 과 \"2\" 로 잘 분리하는지 테스트")
	void splitTwoLengthStringArrayTest() {
		String value = "1,2";
		String[] splitValue = value.split(",");

		assertThat(splitValue).contains("1");
		assertThat(splitValue).contains("2");
	}

	@Test
	@DisplayName("\"1\" 을 , 로 split 했을 때 \"1\" 만을 포함하는 배열을 반환하는지 테스트")
	void splitOneLengthStringArrayTest() {
		String value = "1";
		String[] splitValue = value.split(",");

		assertThat(splitValue).containsExactly("1");
	}

	@Test
	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 \"()\"을 제거하고 \"1,2\"를 반환하는지 테스트")
	void subStringTest() {
		String value = "(1,2)";

		assertThat(value.substring(1, 4)).isEqualTo("1,2");
	}

	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 테스트")
	void charAtTest(int index, char charAtValue) {
		String value = "abc";

		assertThat(value.charAt(index)).isEqualTo(charAtValue);
	}

	@Test
	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치 값을 벗어났을때 StringIndexOutOfBoundsException 발생하는지 테스트")
	void charAtExceptionTest() {
		String value = "abc";

		assertThatThrownBy(() -> {
			value.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}

}
