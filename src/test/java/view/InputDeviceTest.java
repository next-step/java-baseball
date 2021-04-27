package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputDeviceTest {

    @ParameterizedTest
    @DisplayName("입력 값이 3 자리수가 아니면 익셉션이 발생한다.")
    @ValueSource(strings = {"1234", "12", "1"})
    public void checkPlayerInputNumbersSize(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidRange(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3 자리 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 숫자가 아니면 익셉션이 발생한다.")
    @ValueSource(strings = {"abc", "가나다", "ㄱㄴㄷ", "ABC", "@#$"})
    public void checkInputValidValue(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidValue(inputNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력 값에 중복된 숫자가 있으면 익셉션이 발생한다.")
    @ValueSource(strings = {"111", "112", "223", "233", "333"})
    public void checkInputValidDuplicate(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidDuplicate(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }


}