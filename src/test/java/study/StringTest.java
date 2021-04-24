package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(" \"1,2\"를 ',' 로 split 했을 때, 1과 2로 잘 분리되는지 테스트. ")
    void splitByCommaContainsTest() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\" 을 ',' 로 split 했을 때, 1만을 포함하는 배열이 반환되는지 테스트.")
    void splitByCommaContainsExactlyTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 를 String 의 substring() 메소드로 '(', ')' 을 제거하고, \"1,2\"를 반환하는지 테스트.")
    void removeFirstAndLastBracketTest() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 를 String 의 charAt() 메소드를 통해 특정 위치의 문자를 가져오는지 테스트. ")
    void charAtTest() {
        String input = "abc";
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            assertThat(input.charAt(i)).isEqualTo(charArray[i]);
        }
    }

    @Test
    @DisplayName("String 의 charAt() 메소드로 특정 위치의 문자를 가져올 때, 위치값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는지 테스트.")
    void isCharAtThrowException() {
        String input = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}
