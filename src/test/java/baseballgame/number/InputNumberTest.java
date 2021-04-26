package baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static baseballgame.util.TypeCastHelper.stringToList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberTest {

    @DisplayName("유효하지 않는 값으로 객체 생성할 경우 예외 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "012", "1234", "112"})
    void validate(String input) {
        List<String> numbers = stringToList(input);
        assertThatThrownBy(() -> new InputNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 InputNumber 생성되는지 확인")
    @Test
    void toList() {
        //given
        String input = "923";
        List<String> numbers = stringToList(input);

        //when
        BaseballNumber inputNumber = new InputNumber(numbers);

        //then
        assertThat(inputNumber).isNotNull();
        assertThat(inputNumber.getNumber()).isInstanceOf(List.class);
        assertThat(inputNumber.getNumber()).isEqualTo(numbers);
    }

}