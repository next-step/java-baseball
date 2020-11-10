package study;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2를 ','로 구분하면 1과 2로 분리")
    void string_split_contain_test() {
        String testStr = "1,2";
        String[] strings = testStr.split(",");
        assertThat(strings).contains("1");
        assertThat(strings).contains("2");
    }

    @Test
    @DisplayName("1을 ,로 구분했을 때 1만 포함하는 배열반환")
    void string_split_containExactly_test() {
        String testStr = "1";
        String[] stringArray = testStr.split(",");
        assertThat(stringArray).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값이 주어졌을때 ()를 제거하고 1,2를 반환")
    void string_substring_test() {
        String testStr = "(1,2)";
        String substring = testStr.substring(1, testStr.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc값이 주어졌을 때 특정위치 문자 가져오기")
    void string_charat_test() {
        String testStr = "abc";
        char str = testStr.charAt(1);
        assertThat(str).isEqualTo('b');
    }

    @Test
    @DisplayName("abc값이 주어지고 특정위치 가져올때, 위치값이 벗어나면 StringIndexOutOfBoundsException")
    void string_charat_StringIndexOutOfBoundsException_test() {
        String testStr = "abc";
        assertThatThrownBy(() -> {
            testStr.charAt(5); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
