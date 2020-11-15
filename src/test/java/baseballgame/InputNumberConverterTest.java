package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberConverterTest {

    InputNumberConverter converter;

    @BeforeEach
    void setUp() {
        converter = new InputNumberConverter();
    }

    @Test
    @DisplayName("입력 받은 세 자릿수 InputNumber로 치환")
    void inputdigit_converTo_inputNumber() {
        String testString = "397";
        InputNumber number = converter.convertToInputNumber(testString);
        assertThat(number).isEqualTo(new InputNumber(testString));
    }

    @Test
    @DisplayName("입력 받은 세자리 수에 0이 들어가면 exception")
    void input_contains_0_then_exception() {
        String testSring = "023";
        assertThatThrownBy( () -> {
           converter.convertToInputNumber(testSring);})
                .isInstanceOf(InputNumberValidException.class)
                .hasMessageContaining("0을 입력 할 수 없습니다");
    }

    @Test
    @DisplayName("입력 받은 값이 네자리면 exception")
    void inputdigit_over3_then_exception() {
        String testString = "1463";
        assertThatThrownBy( () -> {
            converter.convertToInputNumber(testString);})
                .isInstanceOf(InputNumberValidException.class)
                .hasMessageContaining("세 자릿수보다 많습니다. 세 자릿수를 입력해 주세요");
    }

    @Test
    @DisplayName("입력 받은 값이 한자리면 exception")
    void inputdigit_under3_then_exception() {
        String testString = "3";
        assertThatThrownBy( () -> {
            converter.convertToInputNumber(testString);})
                .isInstanceOf(InputNumberValidException.class)
                .hasMessageContaining("세 자릿수보다 적습니다. 세 자릿수를 입력해 주세요");
    }

    @Test
    void input_contains_char_then_exception() {
        String testString = "d26";
                assertThatThrownBy( () -> {
                    converter.convertToInputNumber(testString);})
                .isInstanceOf(InputNumberValidException.class)
                .hasMessageContaining("숫자만 입력 가능합니다");
    }
}