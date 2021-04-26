package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 요구사항 1
 */
public class StringSplitTest {

	@DisplayName("문자열 '1,2'를 `,`로 split 했을 때 1과 2로 분리 성공 테스트")
	@Test
	void contains_split() {
		// given
		String numStr = "1,2";

		// when
		String[] numArr = numStr.split(",");

		// then
		assertThat(numArr).contains("1", "2");
	}

	@DisplayName("문자열 '1'을 `,`로 split 했을 때 1만 포함하는 배열 반환 성공 테스트")
	@Test
	void contains_exactly_split() {
		// given
		String numStr = "1";

		// when
		String[] numArr = numStr.split(",");

		// then
		assertThat(numArr).containsExactly("1");
	}
}
