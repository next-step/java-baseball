package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    /**
     * 요구사항 1-1
     */
    @Test
    void splitStringTest() {
        // given
        String string = "1,2";

        // when
        String[] splited = string.split(",");

        // then
        assertThat(splited).contains("1");
        assertThat(splited).contains("2");
        assertThat(splited).containsExactly("1", "2");
    }

    /**
     * 요구사항 1-2
     */
    @Test
    void splitOneLengthStringTest() {
        // given
        String string = "1";

        // when
        String[] splited = string.split(",");

        // then
        assertThat(splited).contains("1");
        assertThat(splited).containsExactly("1");
    }

    /**
     * 요구사항 2
     */
    @Test
    void substringTest() {
        // given
        String string = "(1,2)";

        // when
        int openParenthesisIndex = string.indexOf("(");
        int closeParenthesisIndex = string.indexOf(")");
        string = string.substring(openParenthesisIndex + 1, closeParenthesisIndex);

        // then
        assertThat(string).isEqualTo("1,2");
    }

    /**
     * 요구사항 3-1
     */
    @Test
    @DisplayName("charAt() 메소드로 특정 위치의 문자를 가져올 수 있다.")
    void extractSpecificPositionCharacterOfStringTest() {
        // given
        String string = "abc";

        // when, then
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
    }

    /**
     * 요구사항 3-2
     */
    @Test
    @DisplayName("charAt() 메소드에서 위치 값을 벗어나면 예외가 발생한다.")
    void extractOutOfBoundsPositionCharacterOfStringTest() {
        // given
        String string = "abc";

        // when, then
        assertThatThrownBy(() -> string.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> string.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
