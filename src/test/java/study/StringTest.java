package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("요구사항1: split() 활용 및 contains, containsExactly")
	void checkSplitTest() {

		splitTest("1,2", new String[] {"1", "2"});
		// StringTest.splitTest("1,2", new String[] {"2", "1"}); // *contaion: True, *contaionExactly: False

		splitTest("1", new String[] {"1"});

		// Split의 리턴형은 String[] 배열이지만, String타입과 비교해도 참
		assertThat("1".split(",")).contains("1");
	}

	void splitTest(String testStr, String[] result) {

		String separator = ",";
		String[] splitStr = testStr.split(separator);

		assertThat(splitStr).contains(result);
		assertThat(splitStr).containsExactly(result); // 차이: 오브젝트 원소의 순서도 동일해야 한다. "1,2"-> {"2", "1"} Error
	}

	@Test
	@DisplayName("요구사항2: substring() 활용")
	void checkSubstringTest() {

		substringTest("(1,2)", "1,2");
		substringTest("(1,2,3,4)", "1,2,3,4");
		// substringTest("0,(1,2,3,4)", "0,1,2,3,4");		// ( 이전 문자열을 모두 자르기 때문에 결과값: 1,2,3,4
		// substringTest("(1,2,3,4),5,6", "1,2,3,4,5,6"); 	// ) 이후 문자열을 모두 자르기 때문에 결과값: 1,2,3,4
	}

	void substringTest(String testStr, String result) {

		String separator1 = "(";
		String separator2 = ")";
		String substringStr = testStr.substring(testStr.indexOf(separator1) + 1, testStr.indexOf(separator2));

		assertThat(substringStr).contains(result);
	}

	@Test
	@DisplayName("요구사항3: charAt() 활용 및 인덱스 참조 에러 대응")
	void checkCharAtTest() {

		chatAtTest("abc", 'b', 1);
		chatAtTest("abcd", 'c', 2);

		// chatAtTest("abcd", 'c', 3);	// indexOutOfBound Error

		chatAtOutIndexTest("abcdef", 6); // 인덱스 예외처리가 일어날 케이스 테스트
		chatAtOutIndexTest("abc", 10);

	}

	void chatAtTest(String testStr, char result, int getIndex) {

		assertThat(testStr.charAt(getIndex)).isEqualTo(result);
	}

	void chatAtOutIndexTest(String testStr, int getIndex) {

		assertThatThrownBy(() -> {
			char tempChar = testStr.charAt(getIndex);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("[" + testStr + "]Index: " + getIndex + ", Size: " + testStr.length());

		/*
		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			testStr.charAt(getIndex);
		}).withMessageMatching("[" + testStr + "]Index: " + getIndex + ", Size: " + testStr.length());

		 */
	}
}
