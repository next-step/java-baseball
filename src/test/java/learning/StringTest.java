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
        String testString = "1,2";

        String[] splitResult = testString.split(separator);

        assertThat(splitResult).contains(expectedResult);
    }

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분되지 않는 단수 요소를 잘 반환하는지 확인")
    @Test
    void splitSingleStringTest() {
        String testString = "1";

        String[] splitResult = testString.split(separator);

        assertThat(splitResult).containsExactly(testString);
    }
}
