package nextstep.study.baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
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

	@Test
	@DisplayName("숫자 리스트형을 문자열 리스트형으로 변환 테스트")
	void testConvertIntListToStringList() {
		// Given
		List<Integer> intList = Arrays.asList(1, 2, 3);
		List<String> stringList = Arrays.asList("1", "2", "3");

		// When
		List<String> convertedStringList = BaseballUtil.convertIntListToStringList(intList);

		// Then
		assertThat(convertedStringList).isEqualTo(stringList);

	}

}
