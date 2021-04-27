package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	@DisplayName("요구사항1")
	void splitTest(){
		String str = "1,2";

		String[] split = str.split(",");

		assertThat(split).contains("1", "2");

		str = "1";

		split = str.split(",");

		assertThat(split).containsExactly("1");
	}


	@Test
	@DisplayName("요구사항2")
	void substringTest(){
		String str = "(1,2)";

		String value = str.substring(1, 4);

		assertThat(value).isEqualTo("1,2");
	}

	@Test
	@DisplayName("junit exception 처리학습을 위해 exception 발생")
	void charAtTest(){
		String value = "abc";
		String exceptionMessage = "String index out of range";

		assertThatThrownBy(() -> value.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining(exceptionMessage);


		// BDD
		// when
		Throwable throwable = catchThrowable(() -> value.charAt(3));

		// then
		assertThat(throwable).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining(exceptionMessage);
	}

	@Test
	void nullPointerExceptionTest(){
		String str = null;

		assertThatNullPointerException()
			.isThrownBy(() -> str.charAt(1));
	}
}
