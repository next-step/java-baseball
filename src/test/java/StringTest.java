import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class StringTest {

    @Test
    void test1(){
        String str = "1,2";
        assertThat(str.split(",")).contains("1", "2");
    }

    @Test
    void test2(){
        String str = "1";
        assertThat(str.split(",")).containsExactly("1");
    }

    @Test
    void test3(){
        String str = "(1,2)";
        assertThat(str.substring(1, str.length()-1)).isEqualTo("1,2");
    }

    @Test
    void test4(){
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
    }

    @DisplayName("Exception Test")
    @Test
    void test5(){
        String str = "abc";
        assertThatThrownBy(()->{
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
