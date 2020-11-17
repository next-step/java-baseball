package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
	
	@Test
	@DisplayName("1,2을 , split 했을 때 1과 2로 잘 분리되는지 확인")
	public void containsTest() {
		String str = "1,2";
		String[] splitStr = str.split(",");
		
		assertThat(splitStr).contains("1", "2");
	}
	
	@Test
	@DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 확인")
	public void containsExactlyTest() {
		String str = "1";
		String[] splitStr = str.split(",");
		
		assertThat(splitStr).containsExactly("1");
	}
	
	@Test
	@DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
	public void substringTest() {
		String str = "(1,2)";
		String splitStr = str.substring(1, 4);
		
		assertThat(splitStr).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오도록 구현")
	public void charAtTest() {
		String str = "abc";
		char cutStr = str.charAt(2);
		
		assertThat(cutStr).isEqualTo('c');
	}
	
	@Test
	@Disabled
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException 발생하는 부분 구현")
	public void stringIndexOutOfBoundsExceptionTest() {
		String str = "abcd";
		
		assertThatThrownBy(() -> {
			str.charAt(7);
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("string index out of range: 7");
		
		fail("StringIndexOutOfBoundsException 가 발생하여야 합니다.");
	}
	
}
