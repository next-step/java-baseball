package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName(value = "'1,2'을 ',' 로 split 했을 때 1과 2로 잘 분리되는지 테스트")
	public void arraySplitTest_1() {
		String input = "1,2";
		String[] result = input.split(",");
		String[] expected = new String[] {"1", "2"};
		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly(expected);
	}

	@Test
	@DisplayName(value = "'1'을 ',' 로 split 했을 때 1만 포함하는 배열이 반환되는지 테스트")
	public void arraySplitTest_2() {
		String input = "1";
		String[] result = input.split(",");
		String[] expected = new String[] {"1"};
		assertThat(result).contains("1");
		assertThat(result).containsExactly(expected);
	}

	@Test
	@DisplayName(value = "'(1,2)'값이 주어졌을 때 substring() 메소드를 활용해 '1,2'를 반환하는지 테스트")
	public void substringTest() {
		String input = "(1,2)";
		String result = input.substring(1, input.indexOf(")"));
		String expected = "1,2";
		assertThat(result).contains("1");
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName(value = "'abc'값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 잘 가져오는지 테스트")
	public void stringCharAtTest_1() {
		String input = "abc";
		char a = input.charAt(0);
		char b = input.charAt(1);
		char c = input.charAt(2);
		char expectedA = 'a';
		char expectedB = 'b';
		char expectedC = 'c';
		assertThat(expectedA).isEqualTo(a);
		assertThat(expectedB).isEqualTo(b);
		assertThat(expectedC).isEqualTo(c);
	}

	@Test
	@DisplayName(value = "'abc'값이 주어졌을 때 charAt() 메소드를 활용해 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생하는지 테스트")
	public void stringCharAtTest_2() {
		String input = "abc";
		assertThatThrownBy(() -> input.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class).
			hasMessageContaining("String index out of range: 3");
	}
}
