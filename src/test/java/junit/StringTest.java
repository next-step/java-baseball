package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTest {
    private static final String DELIMITER = ",";

    @DisplayName("요구사항1. 구분자로 문자열 분리 - 구분자가 있는경우")
    @Test
    void split_string_value_containing_delimiter() {
        //given
        String stringValue = "1,2";

        //when
        String[] splitValue = stringValue.split(DELIMITER);

        //then
        assertThat(splitValue).containsExactly("1", "2");
    }

    @DisplayName("요구사항1. 구분자로 문자열 분리 - 구분자가 없는경우")
    @Test
    void split_string_value_no_delimiter() {
        //given
        String stringValue = "1";

        //when
        String[] splitValue = stringValue.split(DELIMITER);

        //then
        assertThat(splitValue).containsExactly("1");
    }

    @DisplayName("요구사항 2. 괄호 내부의 문자열을 반환")
    @Test
    void substring_value() {
        //given
        String value = "(1,2)";

        //when
        int beginIndex = value.indexOf("(") + 1; //include
        int endIndex = value.indexOf(")"); //exclude
        String substring = value.substring(beginIndex, endIndex);

        //then
        assertEquals("1,2", substring);
    }

    @DisplayName("요구사항3. 문자열의 특정위치 문자 반환")
    @ParameterizedTest
    @CsvSource(value = {"abc:0:a", "abc:1:b", "abc:2:c"}, delimiter = ':')
    void charAt(String value, int index, char expected) {
        //when
        char actual = value.charAt(index);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("요구사항3. 문자열의 특정 위치 문자 반환 - 잘못된 위치 입력")
    @Test
    void charAt_with_wrong_index() {
        //given
        String value = "abc";
        int index = value.length() + 1;

        //when
        assertThatThrownBy(() -> value.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}