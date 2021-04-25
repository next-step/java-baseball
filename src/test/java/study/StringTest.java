package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

	@Test
	@DisplayName("1,2 을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
	public void split(){
		String[] splitArr = "1,2".split(",");
		assertThat(splitArr).contains("1","2");
	}

	@Test
	@DisplayName("1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지확인")
	public void splitOneInput(){
		String[] splitArr = "1".split(",");
		assertThat(splitArr).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2)값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환")
	public void substring(){
		String text = "(1,2)";
		String substringText = text.substring(text.indexOf("(")+1, text.indexOf(")"));
		assertThat(substringText).isEqualTo("1,2");
	}

	@Test
	@DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자 반환")
	public void charAt(){
    	String text = "abc";
		assertThat(text.charAt(0)).isEqualTo('a');
	}

	@Test
	@DisplayName("charAt() 으로 특정 위치 문자 가져올때 위치값 벗어나면 StringIndexOutOfBoundsException 발생")
	public void stringIndexOutOfBoundsException(){
		String text = "abc";
		assertThatThrownBy(() -> {
		    text.charAt(text.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
	}
}
