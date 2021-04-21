package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split 처리 정상")
    void split() {
        // given
        String target = "1,2";

        // when
        String[] splitTarget = target.split(",");

        // then
        assertThat(2).isEqualTo(splitTarget.length);
        assertThat(splitTarget).containsExactly("1", "2");
    }

    @Test
    @DisplayName("구분자가 아닌 문자로 split 했을 때 정상처리")
    void split_withoutDelimiter() {
        // given
        String target = "1";

        // when
        String[] splitTarget = target.split(",");

        // then
        assertThat(1).isEqualTo(splitTarget.length);
        assertThat(splitTarget).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 자르기")
    void substring() {
        // given
        String target = "(1,2)";

        // when
        String substring = target.substring(1, 4);

        // then
        assertThat("1,2").isEqualTo(substring);
    }
}
