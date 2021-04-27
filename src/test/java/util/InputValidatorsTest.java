package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class InputValidatorsTest {

    @DisplayName("사용자 입력 값에 대한 3자리 체크")
    @Test
    void validatorInputNumberLength() {
        String inputNumber = "32533";
        InputValidators inputValidators = new InputValidators(inputNumber);

        assertThrows(IllegalArgumentException.class, () -> inputValidators.validators());
        assertThatThrownBy(() -> {
            inputValidators.validators();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리를 입력해주세요.");
    }

    @DisplayName("사용자 입력 값에 대한 Integer 체크")
    @Test
    void validatorInputNumberInteger() {
        String inputNumber = "abc";
        InputValidators inputValidators = new InputValidators(inputNumber);

        assertThrows(NumberFormatException.class, () -> inputValidators.validators());
        assertThatThrownBy(() -> {
            inputValidators.validators();
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @DisplayName("사용자 입력 값을 List 로 변환한다.")
    @Test
    void validatorInputNumberConvert() {
        String inputNumber = "345";

        List<Integer> inputNumbers = new InputValidators(inputNumber).convert();

        assertThat(inputNumbers).containsExactly(3, 4, 5);
    }
}