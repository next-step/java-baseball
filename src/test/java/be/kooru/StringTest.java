package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void 요구사항1() {

        String s = "1,2";
        String[] split = s.split(",");

        Assertions.assertThat(split)
                .isNotNull()
                .startsWith("1")
                .contains("1")
                .contains("2")
                .endsWith("2");


        s = "1,";
        split = s.split(",");

        Assertions.assertThat(split)
                .isNotNull()
                .containsExactly(new String[]{"1"})
                .endsWith("1");

    }

    @Test
    void 요구사항2() {

        String s = "(1,2)";
        s = s.substring(1, 4);
        Assertions.assertThat(s)
                .isNotNull()
                .contains("1,2");
    }

    @Test
    void 요구사항3() {

        String s = "abc";
        Assertions.assertThatThrownBy(() -> {
            s.charAt(5);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

    }

}
