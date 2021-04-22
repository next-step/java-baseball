package nextstep.study.baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballUtilTest {

	@Test
	@DisplayName("중복문자 제거 테스트")
	void testRemoveDuplicateChar() {
		// Given
		String strDupNumbers = "111111122222223333333";

		// When
		String result = BaseballUtil.removeDuplicateChar(strDupNumbers);

		// Then
		assertThat(result).isEqualTo("123");
	}

}
