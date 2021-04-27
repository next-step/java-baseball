package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputDeviceTest {

    @ParameterizedTest
    @DisplayName("입력 값이 3 자리수가 아니면 익셉션이 발생한다.")
    @ValueSource(strings = {"1234", "12", "1"})
    public void checkPlayerInputNumberBySize(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidRange(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3 자리 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 숫자가 아니면 익셉션이 발생한다.")
    @ValueSource(strings = {"abc", "가나다", "ㄱㄴㄷ", "ABC", "@#$"})
    public void checkPlayerInputNumberByValue(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidValue(inputNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력 값에 중복된 숫자가 있으면 익셉션이 발생한다.")
    @ValueSource(strings = {"111", "112", "223", "233", "333"})
    public void checkPlayerInputNumberByDuplication(String inputNumber) {
        assertThatThrownBy(() -> InputDevice.checkInputValidDuplicate(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("게임을 종료 후 입력 값은 1 또는 2만 허용한다. (재시작 여부 확인)")
    @ValueSource(ints = {0,3,4})
    public void checkPlayerInputProcessCodeByRange(int processCode) {
        assertThatThrownBy(() -> InputDevice.checkProcessCodeRange(processCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못 입력하셨습니다.");
    }
}