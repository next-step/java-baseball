package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/21
 * Time : 10:56 PM
 */

class StringTest {
    @Test
    @DisplayName("요구사항1 split")
    void split() {
        String[] array  = "1,2".split(",");
        assertThat(array.length).isEqualTo(2);
        //assertThat(array).contains("1", "2");     // 순서가 달라도 true return
        assertThat(array).containsExactly("1", "2");

        array = "1".split(",") ;
        assertThat(array.length).isEqualTo(1);
        assertThat(array).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 substring")
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 charAt")
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> System.out.println(str.charAt(3))).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
