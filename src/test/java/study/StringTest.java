package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] actual = "1,2".split(",");

        assertThat(actual).hasSize(2)
                .contains("1", "2")
                .containsExactly("1", "2");
    }

    @Test
    void split_just_one() {
        String[] result = "1".split(",");

        assertThat(result).hasSize(1)
                .contains("1")
                .containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";

        String result = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt(int index, String expected) {
        String value = "abc";

        assertThat(value.charAt(index)).isEqualTo(expected);
    }
}
