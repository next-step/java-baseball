package string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    static final String ABC = "abc";

    @Test
    void StringSplit() {
        String s = "1,2";
        String[] sa = s.split(",");
        Assertions.assertThat(sa).contains("1", "2");
    }

    @Test
    void StringSplit2() {
        String s = "1";
        String[] sa = s.split(",");
        Assertions.assertThat(sa).containsExactly("1");
    }

    @Test
    void StringRemove() {
        String s = "(1,2)";
        String ss = "1,2";
        s = s.replace("(", "");
        s = s.replace(")", "");
        Assertions.assertThat(s).isEqualTo(ss);
    }

    @Test
    @DisplayName("check out of bound for String.charAt")
    void StringOutofBound() {
        Assertions.assertThat(ABC.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("check out of bound for String.charAt")
    void StringOutofBound2() {
        Assertions.assertThat(ABC.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("check out of bound for String.charAt")
    void StringOutofBound3() {
        Assertions.assertThatThrownBy(() -> {
            ABC.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
