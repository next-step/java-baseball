package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test_요구사항_1() {
		String in1 = "1,2";
		assertThat(in1.split(",")).contains("1").contains("2");
		assertThat(in1.split(",")).containsExactly("1", "2");
		
		String in2 = "1";
		assertThat(in2.split(",")).containsExactly("1");
	}
	
	String removeBrackets(String in) {
		String tmp = in;
		if (tmp.startsWith("(")) {
			tmp = tmp.substring(1, tmp.length());
		}
		
		if (tmp.endsWith(")")) {
			tmp = tmp.substring(0, tmp.length()-1);
		}
		return tmp;
	}
	
	@Test
	void test_요구사항_2() {
		String in = "(1,2)";
		assertThat(removeBrackets(in)).isEqualTo("1,2");
	}
	
	@Test
	void test_요구사항_3_1() {
		String in = "abc";
		assertAll(
				()->assertThat(in.charAt(0)).isEqualTo('a'),
				()->assertThat(in.charAt(1)).isEqualTo('b'),
				()->assertThat(in.charAt(2)).isEqualTo('c')
			);
	}
	
	@Test
	void test_요구사항_3_2() {
		String in = "abc";
		
		String outOfIndexErrMsg = "String index out of range: \\d+";
		assertThatThrownBy(()->{
			in.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
		  .hasMessageMatching(outOfIndexErrMsg);
		
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(()->{
			in.charAt(4);
		}).withMessageMatching(outOfIndexErrMsg);
	}

}
