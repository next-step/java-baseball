package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void testSplit(){
        String str1 = "1,2";
        String str2 = "1";
        String[] res1 = str1.split(",");
        String[] res2 = str2.split(",");

        assertThat(res1).contains("1", "2");
        assertThat(res2).containsExactly("1");
    }

    @Test
    public void testSubstring(){
        String str = "(1,2)";
        String res = str.substring(1,4);

        assertThat(res).isEqualTo("1,2");
    }

    @DisplayName("charAt test")
    @Test
    public void testCharAt(){
        String str = "abc";
        char first = str.charAt(0);

        assertThat(first).isEqualTo('a');
        assertThatThrownBy(() -> {
            String abc = "abc";
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
