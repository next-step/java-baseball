package nextstep.study.baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballUtilTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

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

	@Test
	@DisplayName("메세지 출력 테스트")
	void testShowMessage() {
		// Given
		String message = "테스트 메세지!!";

		// When
		BaseballUtil.showMessage(message);

		// Then
		assertThat(message).isEqualTo(outputStreamCaptor.toString());
	}

}
