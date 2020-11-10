package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("String 클래스의 split 메서드가 구분자로 구분된 복수의 요소를 잘 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void splitManyStringTest(String expectedResult) {
        String separator = ",";
        String testTarget = "1,2";

        String[] splitResult = testTarget.split(separator);

        assertThat(splitResult).contains(expectedResult);
    }

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분되지 않는 단수 요소를 잘 반환하는지 확인")
    @Test
    void splitSingleStringTest() {
        String separator = ",";
        String testTarget = "1";

        String[] splitResult = testTarget.split(separator);

        assertThat(splitResult).containsExactly(testTarget);
    }

    @DisplayName("String 클래스의 substring 메서드로 문자열을 원하는만큼 잘라낼 수 있는지 확인")
    @Test
    void substringTest() {
        String testTarget = "(1,2)";
        String expected = "1,2";

        int beginIndex = 1;
        int endIndex = testTarget.length() - 1;

        assertThat(testTarget.substring(beginIndex, endIndex)).isEqualTo(expected);
    }

    @DisplayName("주어진 값에서 String 클래스의 내장 charAt 메서드로 특정 위치의 문자열을 가져올 수 있는지 확인")
    @ParameterizedTest
    @MethodSource("charAtTestResource")
    void charAtTest(int index, char expectedResult) {
        String testTarget = "abc";

        assertThat(testTarget.charAt(index)).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> charAtTestResource() {
        return Stream.of(
                Arguments.of(0, 'a'),
                Arguments.of(1, 'b'),
                Arguments.of(2, 'c')
        );
    }

    @DisplayName("주어진 문자열의 index를 벗어난 위치로 charAt 메서드를 실행 시 어떤 에러가 발생하는지 확인")
    @Test
    void charAtOutOfBoundTest() {
        String testTarget = "abc";
        int outOfBoundIndex = testTarget.length();

        assertThatThrownBy(() -> testTarget.charAt(outOfBoundIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
