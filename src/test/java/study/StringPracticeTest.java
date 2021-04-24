package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringPracticeTest {
    @DisplayName("두개 문자를 입력 받았을때 숫자를 두개 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "(1,2)"})
    void splitWithTwoNumber(String input) {
        StringPractice stringPractice = new StringPractice(input);

        String delimiter = ",";

        assertThat(stringPractice.splitWith(delimiter)).containsExactly(1,2);
    }

    @DisplayName("한개 문자를 입력 받았을때 숫자를 한개 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "(1)"})
    void splitWithOneNumber(String input) {
        StringPractice stringPractice = new StringPractice(input);

        String delimiter = ",";

        assertThat(stringPractice.splitWith(delimiter)).containsExactly(1);
    }
}
