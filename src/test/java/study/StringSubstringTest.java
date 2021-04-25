package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 요구사항 2
 */
public class StringSubstringTest {

	@DisplayName("문자열 '(1,2)'에서 substring을 활용해 ()를 제거하고 '1,2' 반환 성공 테스트")
	@Test
	void substring() {
		// given:
		String givenStr = "(1,2)";

		// when:
		String substring = givenStr.substring(1, 4);

		// then:
		Assertions.assertThat(substring).isEqualTo("1,2");
	}
}
