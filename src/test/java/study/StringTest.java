package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("요구사항 1 - split")
    @ParameterizedTest
    @CsvSource(value = {"1,2=1:2", "1,=1"}, delimiter = '=')
    void splitTest(String data, String answer) {
        // given
        String[] split = data.split(",");

        // than
        assertThat(split)
            .containsExactly(answer.split(":"));
    }


    @DisplayName("요구사항 2 - substring")
    @Test
    void substring() {
        // given
        String data = "(1,2)";

        // when
        // beginIndex는 index 포함해서 시작하기 때문에 "(" 다음 문자를 지정하기 위해 + 1 처리
        int beginIndex = data.indexOf("(") + 1;
        int endIndex = data.indexOf(")");

        // then
        assertThat(beginIndex).isEqualTo(1);
        assertThat(endIndex).isEqualTo(4);
        assertThat(data.substring(beginIndex, endIndex)).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - charAt")
    @Test
    void charAt() {
        // given
        final String data = "abc";
        final int OVER_INDEX = data.length() + 1;

        // then
        assertThat(data.charAt(0)).isEqualTo('a');

        String message = "String index out of range: " + OVER_INDEX;
        assertThatThrownBy(()->data.charAt(OVER_INDEX))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage(message)
        ;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(()->data.charAt(OVER_INDEX))
            .withMessage(message)
        ;
    }

}
