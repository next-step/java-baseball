package study;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTest {
    // 요구사항 1
    @Test
    void splitTest() {
        String[] check = "1,2".split(",");
        String[] result = new String[2];
        result[0] = "1";
        result[1] = "2";

        assertArrayEquals(result, check);
    }
    // 요구사항2
    @Test
    void subStringTest() {
        String check = "(1,2)".substring(1,4);
        String result = "1,2";

        assertEquals(result, check);
    }
    //요구사항 3
    @Test
    @DisplayName(value = "특정문자 테스트")
    void charAtStringTest() {
//        String check = String.valueOf("abc".charAt(4));
        String check = String.valueOf("abc".charAt(1));
        String result = "a";

        assertEquals(result, check);
    }
}
