import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {


    @Test
    @DisplayName("1,2의 값이 있을 때 배열로 반환 되는지 테스트")
    public void stringSplitTest() {

        String str = "1,2";
        assertThat(str.split(",")).contains("1","2");

    }

    @Test
    @DisplayName("1,의 값이 있을 때 배열로 반환 되는지 테스트")
    public void stringSplit2Test() {

        String target = "1,";
        assertThat(target.split(",")).containsExactly("1");

    }

    @Test
    @DisplayName("(1,2)의 값이 있을때 () 제거하고 1,2를 반환 되는지 테스트")
    public void stringSubStringTest() {

        String target = "(1,2)";
        String subStr = target.substring(target.indexOf("(") + 1, target.indexOf(")"));
        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc의 값이 있을 때, charAt()을 사용하여, 특정 문자의 위치 반환 테스트")
    public void stringChatAtTest() {
        String str = "abc";
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++) {
            assertThat(str.charAt(i)).isEqualTo(charArray[i]);
        }

    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    public void stringIndexOutOfBoundsExceptionTest() {
        String str = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(4);
                }).withMessageMatching("Index: 4, Size: 3");

    }

}
