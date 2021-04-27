package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@Test
	@DisplayName("요구사항1-1. \"1,2\"을 ,로 split했을 때 1,2로 잘 분리되는지 확인하는 테스트")
	public void splitContains() {
		String inputStr = "1,2";

		String[] splitted = inputStr.split(",");

		assertThat(splitted).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항1-2. \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
	public void splitContainsExactly() {
		String inputStr = "1";

		String[] splitted = inputStr.split(",");

		assertThat(splitted).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항2. \"(1,2)\" 을 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환되는지 확인하는 테스트")
	public void subStr() {
		String inputStr = "(1,2)";

		String subStr = inputStr.substring(1, 4);

		assertEquals(subStr, "1,2");
	}

	@ParameterizedTest
	@CsvSource(value = {"0,a", "1,b", "2,c"})
	@DisplayName("요구사항 3-1. \"abc\" 값이 주어졌을 때 String의 charAt()메소드를 활용해 특정 위치의 문자를 가져올 수 있는지 확인하는 테스트")
	public void charAt(int index, char compareChar) {
		String inputStr = "abc";

		char findChar = inputStr.charAt(index);

		assertEquals(findChar, compareChar);
	}

	@Test
	@DisplayName("요구사항 3-2. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인하는 테스트")
	public void stringIndexOutOfBoundsException() {
		String inputStr = "abc";

		int limitIndex = inputStr.length() + 1;

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> inputStr.charAt(limitIndex))
			.withMessageMatching("String index out of range: " + limitIndex);
	}
}
