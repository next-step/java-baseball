package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("학습 테스트 - String")
public class StringTest {

	@DisplayName("문자열 split 분리 후 contains 테스트")
	@Test
	public void containsTest() {
		String target = "1,2";
		String[] actual = target.split(",");

		String expectFirst = "1";
		String expectSecond = "2";

		assertThat(actual).contains(expectFirst, expectSecond);
	}

	@DisplayName("문자열 split 분리 후 containsExactly 테스트")
	@Test
	public void containsExactlyTest() {
		String target = "1";
		String[] actual = target.split(",");
		String[] expect = {"1"};

		assertThat(actual).containsExactly(expect);
	}

	@DisplayName("문자열 substring 테스트")
	@Test
	public void substringTest() {
		String target = "(1,2)";
		String actual = target.substring(1, 4);
		String expect = "1,2";

		assertThat(actual).isEqualTo(expect);
	}

	@DisplayName("charAt()으로 발생하는 IndexOutOfBoundsException 에러 테스트")
	@Test
	public void charAtTest() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				String target = "abc";
				int targetIndex = 3;
				try {
					char c = target.charAt(targetIndex);
				} catch (StringIndexOutOfBoundsException e) {
					throw new StringIndexOutOfBoundsException("Index: " + targetIndex + ", Size: " + target.length());
				}
			}).withMessageMatching("Index: \\d+, Size: \\d+");
	}
}
