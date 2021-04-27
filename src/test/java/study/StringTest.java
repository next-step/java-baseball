package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("String split 테스트")
	public void stringSplitTest1() {
		assertThat("1,2".split(","))
			.contains("1", "2");
	}

	@Test
	@DisplayName("구분자가 미포함된 String split 테스트")
	public void stringSplitTest2() {
		assertThat("1".split(","))
			.containsExactly("1");
	}

	@Test
	@DisplayName("String substring 테스트")
	public void stringSubstringTest() {
		assertThat("(1,2)".substring("(1,2)".indexOf("(") + 1, "(1,2)".indexOf(")")))
			.isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("String charAt Exception 테스트")
	public void stringCharAtExceptionTest() {
		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("Index: 3, Size: 3");
	}
}
