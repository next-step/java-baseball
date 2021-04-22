package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("'1,2'를 ',' 로 split 했을 때 1과 2로 잘 분리가 되는가?")
	void splitString1() {
		// given
		String target = "1,2";
		// when
		String[] split = target.split(",");
		// then
		assertThat(split[0]).isEqualTo("1");
		assertThat(split[1]).isEqualTo("2");
		assertThat(split)
			.contains("1")
			.contains("2")
			.containsExactly("1", "2");
	}

	@Test
	@DisplayName("'1'을 ',' 로 split 했을 때 1만 포함하는 배열이 반환되는가?")
	void splitString2() {
		// given
		String target = "1";
		// when
		String[] split = target.split(",");
		// then
		assertThat(split).containsExactly("1");
	}

	@Test
	@DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring()메소드를 활용해 ()을 제거하고 '1,2를 반환 하도록 구현한다'")
	void substringString() {
		// given
		String target = "(1,2)";
		// when
		String substring = target.substring(1, 4);
		// then
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("String의 charAt()메소드를 활용하여 특정위치의 문자값을 가져올때 위치범위가 벗어날 경우의 예외상황")
	void stringIndexOutOfBoundExceptionTest() {
		String target = "abc";
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
					target.charAt(5);
				}
			);
	}
}
