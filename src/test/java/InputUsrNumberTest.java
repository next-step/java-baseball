import baseBall.util.InputUserNumber;
import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputUsrNumberTest {

    private InputUserNumber inputUserNumber = new InputUserNumber();

    @DisplayName("사용자 입력 숫자 길이 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = "123")
    public void checkUserNumberLengthTest(String input) {
        assertThat(inputUserNumber.checkNumberLength(input)).isTrue();
    }

    @DisplayName("사용자 입력 숫자 중복 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = "113")
    public void checkDuplicateNumberTest(String input) {
        assertThat(inputUserNumber.checkDuplicateNumber(input)).isTrue();
    }

    @DisplayName("사용자 입력 숫자에서 숫자외 다른 문자열 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = "123")
    public void checkNumberFormat(String input) {
        assertThat(inputUserNumber.checkNumberFormat(input)).isTrue();
    }

}
