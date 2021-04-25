package nextstep.study.baseball.util;

import nextstep.study.baseball.common.BaseConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유틸 테스트")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class BaseballUtilTest {

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@DisplayName("01. 중복문자 제거 테스트")
	void testRemoveDuplicateChar() {
		// Given
		String strDupNumbers = "111111122222223333333";

		// When
		String result = BaseballUtil.removeDuplicateChar(strDupNumbers);

		// Then
		assertThat(result).isEqualTo("123");
	}

	@Test
	@DisplayName("02. 숫자 리스트형을 문자열 리스트형으로 변환 테스트")
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
	@DisplayName("03. 메세지 출력 테스트")
	void testShowMessage() {
		// Given
		String message = "테스트 메세지!!";

		// When
		BaseballUtil.showMessage(message);

		// Then
		assertThat(message).isEqualTo(outputStreamCaptor.toString());
	}

	@Test
	@DisplayName("04. 유효한 값을 입력시 출력메세지 테스트")
	void testShowInputMessage() {
		int makeCount = 0;
		String message = BaseballUtil.getInputMessage(makeCount);
		assertThat(message).isEqualTo(BaseConstants.MESSAGE_INPUT_NUMBER);
	}

	@Test
	@DisplayName("05. 유효하지 않은 값을 입력시 출력메세지 테스트")
	void testShowWrongInputMessage() {
		int makeCount = 1; //1회이상 재입력
		String message = BaseballUtil.getInputMessage(makeCount);
		assertThat(message).isEqualTo(BaseConstants.MESSAGE_INPUT_WRONG_NUMBER);
	}

	@Test
	@DisplayName("06. 입력값이 숫자가 아닐경우 체크")
	void testCheckWorngNumber() {
		String strNum = "1a3";
		boolean isNum = BaseballUtil.isNumeric(strNum);
		assertThat(isNum).isFalse();
	}

	@Test
	@DisplayName("07. 입력값이 숫자인 경우 테스트")
	void testCheckNumber() {
		String strNum = "123";
		boolean isNum = BaseballUtil.isNumeric(strNum);
		assertThat(isNum).isTrue();
	}

	@Test
	@DisplayName("08. 입력값이 3자리가 아닌경우 테스트")
	void testCheckWrongLength() {
		String strNum = "12";
		int length = 3;
		boolean result = BaseballUtil.isLength(strNum, length);
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("09. 입력값이 3자리인 경우 테스트")
	void testCheckLength() {
		String strNum = "123";
		int length = 3;
		boolean result = BaseballUtil.isLength(strNum, length);
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("10. 문자열을 숫자형 리스트로 변환 테스트")
	void testStrToIntArray() {
		String strNum = "456";
		List<Integer> list = BaseballUtil.convertStringToIntList(strNum);
		StringBuilder sb = new StringBuilder();
		for (Integer num : list) {
			sb.append(String.valueOf(num));
		}
		assertThat(sb.toString()).isEqualTo(strNum);
	}

	@ParameterizedTest
	@DisplayName("11. 입력된 숫자가 범위내의 character가 아닐때")
	@ValueSource(strings = {"012", "1234"})
	void testBetweenWrongStrNum(String str) {
		boolean result = BaseballUtil.isBetweenStrNum(str);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@DisplayName("12. 입력된 숫자가 범위내의 character 일때")
	@ValueSource(strings = {"123", "942", "751"})
	void testBetweenStrNum(String str) {
		boolean result = BaseballUtil.isBetweenStrNum(str);
		assertThat(result).isTrue();
	}

}
