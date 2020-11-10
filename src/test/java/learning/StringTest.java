package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    private String separator = ",";

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분된 복수의 요소를 잘 반환하는지 확인")
    @Test
    void splitManyStringTest() {
        String testString = "1,2";

        String[] splitResult = testString.split(separator);

        assertThat(splitResult).contains("1", "2");
    }

    @DisplayName("String 클래스의 split 메서드가 구분자로 구분되지 않는 단수 요소를 잘 반환하는지 확인")
    @Test
    void splitSingleStringTest() {
        String testString = "1";

        String[] splitResult = testString.split(separator);

        assertThat(splitResult).containsExactly("1");
    }
}
