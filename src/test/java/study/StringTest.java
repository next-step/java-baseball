package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void charAt() {
        // given
        String target = "abc";

        // when then
        assertThat('a').isEqualTo(target.charAt(0));
        assertThat('b').isEqualTo(target.charAt(1));
        assertThat('c').isEqualTo(target.charAt(2));
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기 - 위치 값이 문자열 크기를 초과했을 때")
    void charAt_outOfBound() {
        // given
        String target = "abc";

        // when then
        assertThatThrownBy(
                () -> target.charAt(3)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
