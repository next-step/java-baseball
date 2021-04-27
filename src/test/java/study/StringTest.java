package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splitByComma() {
        String str1 = "1,2";
        String[] splitValues1 = str1.split(",");
        assertThat(splitValues1).containsExactly("1", "2");

        String str2 = "1";
        String[] splitValues2 = str2.split(",");
        assertThat(splitValues2).containsExactly("1");
    }

    @Test
    void substringWithoutBracket() {
        String str = "(1,2)";
        String substringStr = str.substring(1, 4);

        assertThat(substringStr).isEqualTo("1,2");
    }

    @DisplayName("charAt() 으로 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    void generateStringIndexOutOfBoundsExceptionUsingCharAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(str.length());
                })
                .withMessageMatching("String index out of range: " + str.length());
    }
}
