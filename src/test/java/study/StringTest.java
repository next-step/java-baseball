package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("학습테스트")
public class StringTest {
    @DisplayName("split 테스트 1 : 1,2를 ,로 split했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void testSplit() {
        String testStr = "1,2";
        String[] splitStr = testStr.split(",");

        assertThat(splitStr).contains("1");
        assertThat(splitStr).contains("2");
        assertThat(splitStr).containsExactly("1", "2");
    }

    @DisplayName("split 테스트 2 : 1을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void testSplit2() {
        String testStr = "1";
        String[] splitStr = testStr.split(",");

        assertThat(splitStr).containsOnly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    void testToString() {
        String testStr = "(1,2)";

        String substringStr = testStr.substring(1, testStr.length()-1);

        assertThat(substringStr).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트 1 : abc 값이 주어졌을 때 특정 위치의 문자를 반환")
    @Test
    void testCharAt() {
        String testStr = "abc";

        char a = 'a';
        char b = 'b';
        char c = 'c';

        assertThat(testStr.charAt(0)).isEqualTo(a);
        assertThat(testStr.charAt(1)).isEqualTo(b);
        assertThat(testStr.charAt(2)).isEqualTo(c);
    }

    @DisplayName("charAt 테스트 2 : 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void testCharAt2() {
        String testStr = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testStr.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
