package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
