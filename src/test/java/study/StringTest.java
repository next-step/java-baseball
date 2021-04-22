package study;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("splitStringUsingComma 메서드에 Input으로 \"1,2\" 이 들어왔을 때, 정상적으로 Split 되는지 테스트 한다. (Contains 사용)")
    public void stringSplitOneCommaTwoUsingContainsTest() {
        StringMethod spliter = new StringMethod();
        List<String> listString = spliter.splitStringUsingComma("1,2");

        assertThat(listString)
                .contains("2", "1");
    }

    @Test
    @DisplayName("splitStringUsingComma 메서드에 Input으로 \"1,2\" 이 들어왔을 때, 정상적으로 Split 되는지 테스트 한다. (ContainsExactly 사용)")
    public void stringSplitOneCommaTwoUsingContainsExactlyTest() {
        StringMethod spliter = new StringMethod();
        List<String> listString = spliter.splitStringUsingComma("1,2");

        // 인덱스까지 맞아야함 Exactly
        assertThat(listString)
                .containsExactly("1","2");
    }

    @Test
    public void stringSplitOneCommaTest() {
        StringMethod spliter = new StringMethod();
        List<String> listString = spliter.splitStringUsingComma("1,");

        assertThat(listString)
                .contains("1");
        assertThat(listString)
                .containsExactly("1");
    }

    @Test
    @DisplayName("Input으로 들어오는 String 외부에 괄호가 있으면 제거하여 Split하는 기능을 테스트 한다.")
    public void stringSplitWithParenthesesTest() {
        StringMethod spliter = new StringMethod();
        List<String> listString = spliter.splitStringUsingComma("(1,2)");

        assertThat(listString)
                .containsExactly("1", "2");
    }

//    @Test
//    @DisplayName("String과 index가 주어졌을 때, index로 해당 String의 charAt() 메소드에서 " +
//            "IndexOutOfBoundsException이 발생하는지 여부를 테스트 한다.")
//    public void StringCharAtIndexExceptionTest() {
//
//        assertThatThrownBy(() -> {
//            assertThat("abc".charAt(3)).isEqualTo('c');
//        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining(
////                "Index: 3, Size: 2"
//                "String index out of range"
//        );
//
//        assertThatThrownBy(() -> {
//            assertThat("abc".charAt(-1)).isEqualTo('c');
//        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining(
//                "Index: 3, Size: 2"
//        );
//
////        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
////            assertThat("abc".charAt(3)).isEqualTo('c');
////        }).withMessageMatching(
////                "Index: \\d+, Size: \\d+"
////        );
//    }
}
