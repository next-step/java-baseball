package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @DisplayName("Requirements1")
    @Test
    void testSplit() {
        String[] strSplit1 = "1,2".split(",");
        assertThat(strSplit1).containsExactly("1", "2");

        String[] strSplit2 = "1".split(",");
        assertThat(strSplit2).contains("1");
    }

    @DisplayName("Requirements2")
    @Test
    void testSubstring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @DisplayName("Requirements3 - throw Exception by using charAt method")
    @Test
    void testIndexOutOfBoundException() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: ");
    }

}
