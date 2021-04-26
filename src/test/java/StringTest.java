import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private String str;

    @DisplayName("1,2의 값이 있을 때 배열로 반환 되는지 테스트")
    @Test
    public void stringSplitTest() {
        str = "1,2";
        assertThat(str.split(",")).contains("1","2");

    }

    @DisplayName("1,의 값이 있을 때 배열로 반환 되는지 테스트")
    @Test
    public void stringSplit2Test() {
        str = "1,";
        assertThat(str.split(",")).containsExactly("1");

    }

    @DisplayName("(1,2)의 값이 있을때 () 제거하고 1,2를 반환 되는지 테스트")
    @Test
    public void stringSubStringTest() {
        str = "(1,2)";
        String subStr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(subStr).isEqualTo("1,2");
    }

    @DisplayName("abc의 값이 있을 때, charAt()을 사용하여, 특정 문자의 위치 반환 테스트")
    @Test
    public void stringChatAtTest() {
        str = "abc";
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++) {
            assertThat(str.charAt(i)).isEqualTo(charArray[i]);
        }

    }

    @DisplayName("StringIndexOutOfBoundsException 테스트")
    @Test
    public void stringIndexOutOfBoundsExceptionTest() {
        str = "abc";
        int index = 10;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);

    }

    @DisplayName("StringIndexOutOfBoundsException 테스트")
    @Test
    public void stringIndexOutOfBoundsExceptionTest2() {
        str = "abc";
        int index = 10;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(index);
                }).withMessageContaining("%d", index);

    }



}
