package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
