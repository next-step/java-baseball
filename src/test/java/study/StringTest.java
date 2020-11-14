package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항 1) \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void splitContains() {
        //given
        String str = "1,2";

        //when
        String[] split = str.split(",");

        //then
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1) \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    public void splitContainsExactly() {
        //given
        String str = "1";

        //when
        String[] split = str.split(",");

        //then
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2) \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 \"1,2\"를 반환할 수 있는지 확인")
    public void substring() {
        //given
        String str = "(1,2)";

        //when
        String substring = str.substring(1, 4);

        //then
        Assertions.assertEquals(substring, "1,2");
    }

    @DisplayName("요구사항 3) \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    public void charAt(int input, char expected) {
        //given
        String str = "abc";

        //when
        char letter = str.charAt(input);

        //then
        Assertions.assertEquals(letter, expected);
    }

    @Test
    @DisplayName("요구사항 3) String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    public void stringIndexOutOfBoundsException() {
        //given
        String str = "abc";
        int out = 1;
        int outRange = str.length() + out;

        //when
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(outRange))
                .withMessageMatching("String index out of range: 4");
    }
}
