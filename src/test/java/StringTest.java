import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

	@Test
	@DisplayName("JUnit 학습하기 요구사항 1 - String split 테스트")
	public void stringSplitTest() {
		String testString1 = "1,2";
		String testString2 = "1";

		String[] splitString1 = testString1.split(",");
		String[] splitString2 = testString2.split(",");

		assertThat(splitString1).contains("1", "2"); // 포함 테스트 성공
		assertThat(splitString1).containsExactly("1", "2"); // 배열 일치 테스트 성공

		assertThat(splitString2).contains("1"); // 포함 테스트 성공
		assertThat(splitString2).containsExactly("1"); // 배열 일치 테스트 성공
	}

	@Test
	@DisplayName("JUnit 학습하기 요구사항 2 - String substring 테스트")
	public void stringSubstringTest() {
		String testString = "(1,2)";

		int leftIndex = testString.indexOf("(") + 1;
		int rightIndex = testString.indexOf(")");

		testString = testString.substring(leftIndex, rightIndex);

		assertThat(testString).contains("1,2").isEqualTo("1,2");
	}

	@Test
	@DisplayName("JUnit 학습하기 요구사항 3 - 'abc' 에서 특정 위치 값에 문자를 가져올때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생 테스트"
			+ "")
	public void stringCharAtIndexExceptionTest() {
		String testString = "abc";
		int searchIndex = 5;

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
			testString.charAt(searchIndex);
		}).withMessage("String index out of range: %d", searchIndex)
				.withMessageContaining("String index out of range")
				.withNoCause();
	}
}
