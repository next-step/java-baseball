package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("String 클래스 의 split 메서드가 구분자로 구분된 복수의 요소를 잘 반환하는지 확인")
    @Test
    void splitManyStringTest() {
        String testString = "1,2";
        String separator = ",";

        String[] splitResult = testString.split(separator);

        assertThat(splitResult).contains("1", "2");
    }
}
