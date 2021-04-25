package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @DisplayName("'1,2'를 1과 2로 잘 분리 되는지 테스트")
    @Test
    public void seperate_1() {
        String input = "1,2";

        String[] splited = input.split(",");

        assertThat(splited).containsExactly("1", "2");
    }

    @DisplayName("'1'을 ,로 split했을 때, 1만 포함하는 배열이 반환되는지 테스트")
    @Test
    public void seperate_2() {
        String input = "1";

        String[] splited = input.split(",");

        assertThat(splited).containsExactly("1");
    }

    @DisplayName("'(1,2)' 값이 주어졌을 때, String의 substring() 메소드를 활용해 ()를 제거하고 '1,2'를 반환하도록 구현")
    @Test
    public void substring() {
        String input = "(1,2)";

        String changed = input.substring(1, 4);

        assertThat(changed).isEqualTo("1,2");
    }

    @DisplayName("'abc' 값이 주어졌을 때, String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현")
    @ParameterizedTest
    @CsvSource(value = {"abc:0:a", "abc:1:b", "abc:2:c"}, delimiter = ':')
    public void charAt(String input, int index, char expected) {

        char selected = input.charAt(index);

        assertThat(selected).isEqualTo(expected);
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올때 위치값 벗어나면 예외 발생 테스트")
    @Test
    public void charAt_exception() {
        String input = "abc";

        Throwable throwable = catchThrowable(() -> {
            input.charAt(3);
        });

        assertThat(throwable).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
