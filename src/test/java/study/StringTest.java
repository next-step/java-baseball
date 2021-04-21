package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 기능 테스트")
public class StringTest {

    @DisplayName("문자열 분리메서드 split 테스트")
    @Test
    void splitTest() {
        //given
        String oneAndTwo = "1,2";
        String one = "1";
        final String delimiter = ",";

        //when
        String[] splitOneAndTwo = oneAndTwo.split(delimiter);
        String[] splitOne = one.split(delimiter);

        //then
        assertThat(splitOneAndTwo).contains("1");
        assertThat(splitOneAndTwo).contains("2");
        assertThat(splitOneAndTwo).containsExactly("1","2");
        assertThat(splitOne).containsOnly("1");
    }

    @DisplayName("문자열 substring 테스트")
    @Test
    void substringTest() {
        //given
        String oneAndTwoWithParenthesis = "(1,2)";

        //when
        String substring = oneAndTwoWithParenthesis.substring(1, oneAndTwoWithParenthesis.length() - 1);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAtTest() {
        //given
        String abc = "abc";

        //when
        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);

        //then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

    }

    @DisplayName("charAt 실패 테스트")
    @Test
    void charAtExceptionTest() {
        //given
        String abc = "abc";

        //when, then
        assertThatThrownBy(()-> abc.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }

}
