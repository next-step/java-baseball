package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split two-unit string value")
    public void splitContain() {
        // given
        String foo = "1,2";

        // when
        String[] splitFoo = foo.split("\\,");

        // then
        assertThat(splitFoo).contains("1", "2");

    }

    @Test
    @DisplayName("split one-length string value")
    public void splitOneUnit() {
        // given
        String foo = "1";

        // when
        String[] splitFoo = foo.split("\\,");

        // then
        assertThat(splitFoo).containsExactly("1");

    }


    @Test
    @DisplayName("erase parenthesis by substring")
    public void eraseParenthesis() {
        // given
        String foo = "(1,2)";

        // when
        String erasedFoo = foo.substring(1, foo.length() -1);

        // then
        assertThat(erasedFoo).isEqualTo("1,2");

    }

    @Test
    @DisplayName("String.charAt occurred StringIndexOutOfBoundsException.")
    public void stringIndexOutOfBoundsException() {
        // given
        String abc = "abc";

        // when & then
        assertThatThrownBy(() -> {abc.charAt(4);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4")
                ;
    }
}
