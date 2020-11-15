package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1 : \"1,2\" 을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void contains() {
        String[] splitArray = "1,2".split(",");

        assertThat(splitArray).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1-2 : \"1\" 을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void containsExactly() {
        String[] splitArray = "1".split(",");

        assertThat(splitArray).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 : \"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(") + 1, input.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1 : \"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt() {
        String input = "abc";
        char[] inputArray = input.toCharArray();
        int size = inputArray.length;

        for (int i = 0; i < size; i++) {
            assertThat(input.charAt(i)).isEqualTo(inputArray[i]);
        }
    }

    @Test
    @DisplayName("요구사항3-2 : String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n" +
            "StringIndexOutOfBoundsException 이 발생하는 부분에 대한 학습 테스트를 구현")
    void stringIndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(100);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 100");
    }
}
