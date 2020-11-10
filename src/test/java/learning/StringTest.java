package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    private String separator = ",";

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분된 복수의 요소를 잘 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void splitManyStringTest(String expectedResult) {
        String testTarget = "1,2";

        String[] splitResult = testTarget.split(separator);

        assertThat(splitResult).contains(expectedResult);
    }

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분되지 않는 단수 요소를 잘 반환하는지 확인")
    @Test
    void splitSingleStringTest() {
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
}
