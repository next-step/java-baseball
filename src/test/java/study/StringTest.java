package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest(){
        String testVal1 = "1,2";
        assertThat(testVal1.split(",")).contains("1","2");
        assertThat(testVal1.split(",")).containsExactly(new String[]{"1","2"});

        String testVal2 = "1";
        assertThat(testVal2.split(",")).contains("1");
        assertThat(testVal2.split(",")).containsExactly(new String[]{"1"});
    }

    @Test
    void subStringTest(){
        String testVal = "(1,2)";
        assertThat(testVal.substring(1,4)).contains("1,2");
    }

    @Test
	@DisplayName("String의 charAt 메소드를 활용해 특정위치의 문문자를 가져오는 테스트")
	void charAtTest(){
    	String testVal = "abc";
    	assertThatThrownBy(() ->{
    		testVal.charAt(6);
		})
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range:");
	}
}
