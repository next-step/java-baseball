package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("콤마로 분리")
    @Test
    public void split() {
        String str = "1,2";
        assertThat(str.split(",")).contains("1", "2");
    }

    @DisplayName("콤마 없을때 콤마로 분리")
    @Test
    public void splitNotContainDelimiter() {
        String str = "1";
        assertThat(str.split(",")).containsExactly("1");
    }

    @DisplayName("문자열 자르기")
    @Test
    public void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");

    }

    @DisplayName("특정 위치의 문자 가져오기")
    @ParameterizedTest
    @CsvSource({"0, a", "1, b", "2, c"})
    public void charAt(int index, char target) {
        String str = "abc";
        assertThat(str.charAt(index)).isEqualTo(target);
    }

}
