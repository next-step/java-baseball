package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringTest {


    @ParameterizedTest
    @MethodSource("provideStringForSplitTest")
    public void splitTest(String parameter, String[] expected) {

        // when
        String[] splitted = parameter.split(",");

        // then
        Assertions.assertThat(splitted).contains(expected);
        Assertions.assertThat(splitted).containsExactly(expected);
    }

    private static Stream<Arguments> provideStringForSplitTest() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    public void substringTest() {

        // given
        String given = "(1,2)";

        // when
        String substring = given.substring(1, 4);

        // then
        Assertions.assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("String 클래스의 charAt 메소드 테스트")
    @ParameterizedTest
    @MethodSource("provideStringForCharAtTest")
    public void charAtTest(String given, int index, char expected) {

        // when
        char charAt = given.charAt(index);

        // then
        Assertions.assertThat(charAt).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringForCharAtTest() {
        return Stream.of(
                Arguments.of("abc", 0, 'a'),
                Arguments.of("abc", 1, 'b'),
                Arguments.of("abc", 2, 'c')
        );
    }

    @DisplayName("String 클래스의 charAt 메소드 StringIndexOutOfBoundException 테스트")
    @ParameterizedTest
    @MethodSource("provideStringForCharAtStringIndexOutOfBoundExceptionTest")
    public void charAtStringIndexOutOfBoundExceptionTest(String given, int index, String expected) {

        Assertions.assertThatThrownBy(() -> {
            char ch = given.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(expected);
    }

    private static Stream<Arguments> provideStringForCharAtStringIndexOutOfBoundExceptionTest() {
        return Stream.of(
                Arguments.of("abc", 3, "String index out of range: 3"),
                Arguments.of("abc", 4, "String index out of range: 4")
        );
    }

    @Test
    public void tes() {
        String[] re = "123".split("");
        System.out.println(re);
    }
}
