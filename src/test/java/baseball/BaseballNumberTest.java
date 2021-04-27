package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputDevice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @ParameterizedTest
    @DisplayName("BaseballNumber 객체의 숫자 범위를 확인한다.")
    @ValueSource(ints= {0,10,11})
    public void checkBaseballNumberByRange(int numbers) {
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 범위는 1 ~ 9 사이로 이루어져야 합니다.");
    }
}