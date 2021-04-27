package pretest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리 되는지 테스트")
    public void split1Test() {

        String str = "1,2";
        assertThat(str.split(",")).contains("1","2");

    }

    @Test
    @DisplayName("'1'을 ,로 split 했을때 1만을 포함하는 배열이 반환 되는지 테스트")
    public void split2Test() {

        String str = "1,";
        assertThat(str.split(",")).containsExactly("1");

    }

    @Test
    @DisplayName("(1,2)의 값이 주어졌을 때 () 제거하고 1,2를 반환 되는지 테스트")
    public void subStringTest() {

        String str = "(1,2)";
        String subStr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc의 값이 있을 때, charAt()을 사용하여, 특정 위치의 문자를 가져오는 학습 테스트")
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
