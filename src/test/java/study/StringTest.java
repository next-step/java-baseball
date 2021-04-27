package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
    @Test
    @DisplayName("요구사항 1 - 성공")
    void split_succeed() {
        // given
        String twoElements = "1,2";
        String oneElement = "1";

        // when
        String[] twoElemOutput = twoElements.split(",");
        String[] oneElemOutput = oneElement.split(",");

        // then
        Assertions.assertThat(twoElemOutput).contains("1", "2");
        Assertions.assertThat(oneElemOutput).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 - 성공")
    void subString_succeed() {
        // given
        String input = "(1,2)";

        // when
        String output = input.substring(1, 4);

        // then
        Assertions.assertThat(output).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("요구사항 3 - 성공")
    void charAt_succeed(int index, char expected) {
        // given
        String input = "abc";

        // when, then
        Assertions.assertThat(input.charAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("요구사항 3 - charAt() 함수의 인자가 문자열 범위를 벗어날 경우 IndexOutOfBoundsException 발생")
    void charAt_fail_inputValueIsOutOfRange() {
        // given
        String input = "abc";

        // when, then
        Assertions.assertThatThrownBy(() -> {
            char output = input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}