package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void splitTest() {

        // given
        String input = "1,2";

        // when
        String[] splited = input.split(",");

        // then
        assertThat(splited).containsExactly("1", "2");
    }


    @Test
    public void splitTest2() {

        // given
        String input = "1";

        // when
        String[] splited = input.split(",");

        // then
        assertThat(splited).containsExactly("1");
    }

    @Test
    public void subStringTest() {

        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("n번째 character 값 얻기")
    @Test
    public void charAtTest() {

        // given
        String input = "abc";

        // when
        char c1 = input.charAt(0);
        char c2 = input.charAt(1);
        char c3 = input.charAt(2);

        // then
        assertThat(c1).isEqualTo('a');
        assertThat(c2).isEqualTo('b');
        assertThat(c3).isEqualTo('c');
    }

    @DisplayName("index 초과시, StringIndexOutOfBoundsException 발생")
    @Test
    public void charAtTest2() {

        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> {
            input.charAt(input.length() + 1);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
