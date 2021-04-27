package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("\"1\"을 ','로 split 했을 때 1 포함한 배열이 되어야 한다")
    @Test
    void splitTest1() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("\"1,2\"을 ','로 split 했을 때 1과 2를 포함한 배열이 되어야 한다")
    @Test
    void splitTest2() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("(\"1,2\")값이 주어졌을 때 \"1,2\"를 반환해야한다")
    @Test
    void substringTestWithParenthesis() {
        final String value = "(1,2)";
        final String actual = value.substring(1, value.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("\"abc\"값이 주어졌을 때 특정 위치의 문자를 가져온다")
    @Test
    void charAtTest() {
        final String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
