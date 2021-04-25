package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 요구사항 3
 */
public class StringCharAtTest {

	@DisplayName("문자열 'abc'가 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 성공 테스트")
	@Test
	void get_char_using_charat() {
		// given
		String givenStr = "abc";

		// when
		char firstChar = givenStr.charAt(0);

		// then
		assertThat(firstChar).isEqualTo('a');
	}

	@DisplayName("String 문자열 범위 밖의 인덱스 참조 시 StringIndexOutOfBoundsException 발생 테스트")
	@Test
	void throw_index_out_of_bounds_exception() {
		// expect
		assertThatThrownBy(() -> {
			"abc".charAt(5);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range");
	}
}
