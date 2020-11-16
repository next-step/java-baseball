package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("입력이 3자리 숫자인 경우 int 배열로 파싱 완료")
    void parseInput() {
        assertThat(InputParser.parse("000")).containsExactly(0,0,0);
        assertThat(InputParser.parse("003")).containsExactly(0,0,3);
        assertThat(InputParser.parse("050")).containsExactly(0,5,0);
        assertThat(InputParser.parse("400")).containsExactly(4,0,0);

        assertThat(InputParser.parse("111")).containsExactly(1,1,1);
        assertThat(InputParser.parse("888")).containsExactly(8,8,8);

        assertThat(InputParser.parse("321")).containsExactly(3,2,1);
        assertThat(InputParser.parse("902")).containsExactly(9,0,2);
    }

    @Test
    @DisplayName("입력이 3자리가 안되는 경우 IllegalArgumentException 발생")
    public void parseInputIllegalArgumentException() {
        assertThatThrownBy(() -> {
            InputParser.parse("9");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            InputParser.parse("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            InputParser.parse("k");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            InputParser.parse("123abcd");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력이 문자가 중간에 끼어있는경우 NumberFormatException 발생")
    public void parseInputNumberFormatException() {
        assertThatThrownBy(() -> {
            InputParser.parse("a00");
        }).isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> {
            InputParser.parse("72;");
        }).isInstanceOf(NumberFormatException.class);
    }

}