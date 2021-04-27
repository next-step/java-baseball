package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 테스트")
class StringTest {

    private String dataForCharAt;

    @BeforeEach
    void setUp() {
        dataForCharAt = "abc";
    }

    @Test
    @DisplayName("String split 테스트")
    void split() {
        String[] result = {"1", "2"};

        assertThat("1,2".split(",")).containsExactly(result);
    }

    @Test
    @DisplayName("대상 String에 값이 1개 일때 split할 경우 테스트")
    void split_onlyOne() {
        String[] result = {"1"};

        assertThat("1".split(",")).containsExactly(result);
    }

    @Test
    @DisplayName("substring을 이용한 괄호 제거 테스트")
    void subString() {
        String data = "(1,2)";

        assertThat(data.substring(data.indexOf("(") + 1, data.indexOf(")"))).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt 테스트")
    void charAt() {

        assertThat(dataForCharAt.charAt(0)).isEqualTo('a');
        assertThat(dataForCharAt.charAt(1)).isEqualTo('b');
        assertThat(dataForCharAt.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String charAt 사용시 범위를 벗어난 경우 테스트")
    void charAt_outOfBound() {
        int targetIndex = dataForCharAt.length() + 1;

        assertThatThrownBy(() -> {dataForCharAt.charAt(targetIndex);})
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(
                new StringBuilder("range: ")
                    .append(targetIndex)
                    .toString());
    }
}
