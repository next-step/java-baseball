package practice.javabasic;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JavaBasicTest {

    @Test
    void returnStrTest() {
        JavaBasic m = new JavaBasic();
        String str = "123";
        assertThat(m.returnStr(str))
                .contains("1");
    }

    @Test
    void splitTest() {
        JavaBasic m = new JavaBasic();
        String str = "1,2";
        String[] arr;
        arr = m.split(str);
        assertThat(arr)
                .contains("1")
                .contains("2");
    }



}
