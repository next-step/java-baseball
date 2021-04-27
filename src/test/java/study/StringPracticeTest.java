package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringPracticeTest {
    private StringPractice stringPractice;

    @DisplayName("두개 문자를 입력 받았을때 숫자를 두개 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "(1,2)"})
    void splitWithTwoNumber(String input) {
        stringPractice = new StringPractice(input);
        String delimiter = ",";

        assertThat(stringPractice.splitWith(delimiter)).containsExactly(1,2);
    }

    @DisplayName("한개 문자를 입력 받았을때 숫자를 한개 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "(1)"})
    void splitWithOneNumber(String input) {
        stringPractice = new StringPractice(input);
        String delimiter = ",";

        assertThat(stringPractice.splitWith(delimiter)).containsExactly(1);
    }

    @DisplayName("문자열에서 유효한 위치의 문자를 리턴한다.")
    @Test
    void findCharacterValidIndex() {
        final String input = "abc";
        stringPractice = new StringPractice(input);
        final int index = 1;

        assertThat(stringPractice.findIndex(index)).isEqualTo('b');
    }

    @DisplayName("문자열에서 유효하지 않은 문자 위치를 찾으면 에러를 던진다.")
    @Test
    void findCharacterWithInvalidIndex() {
        final String input = "abc";
        stringPractice = new StringPractice(input);
        final int index = 100;

        assertThatThrownBy(() -> {
            stringPractice.findIndex(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
