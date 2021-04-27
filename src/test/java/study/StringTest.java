package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("string 테스트")
public class StringTest {
    @DisplayName(" \"1,2\" 를 ,로 분리하여 [1,2] 반환 테스트")
    @Test
    void splitContainsTest(){
        assertThat("1,2".split(",")).contains("1","2");
    }

    @DisplayName(" \"1\" 을 ,로 분리 시 [1] 반환 테스트")
    @Test
    void splitContainsExactlyTest(){
        assertThat("1".split(",")).containsExactly(("1"));
    }

    @DisplayName("(1,2) 의 괄호를 제거하고 1,2 반환 테스트")
    @Test
    void substringTest(){
        String in = "(1,2)";
        String out = "(1,2)".substring(1, in.indexOf(")"));
        assertThat(out).isEqualTo("1,2");
    }

    @DisplayName("abc가 주어졌을 때 특정 위치 문자 가져오는지 테스트")
    @Test
    void charAtTest(){
        String in = "abc";
        char[] cmp = in.toCharArray();
        for(int i=0; i<in.length(); i++){
            assertThat(in.charAt(i)).isEqualTo(cmp[i]);
        }
    }

    @DisplayName("charAt 범위 벗어날 시 IndexOutOfBoundsException 발생 테스트")
    @Test
    void IndexOutOfBoundsExceptionTest(){
        String in = "abc";
        assertThatThrownBy(()-> in.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()-> in.charAt(4)).withMessageMatching("String index out of range: \\d");
    }
}
