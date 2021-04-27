package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReceivingBaseballNumberTest {
    private ReceivingBaseballNumber receivingBaseballNumber;

    @Test
    @DisplayName("숫자만 입력시 테스트 성공")
    public void test_success_when_receive_only_numbers() {
        String playerInput = "875";
        receivingBaseballNumber = new ReceivingBaseballNumber(new Scanner(playerInput));
        String receiveBaseballNumber = receivingBaseballNumber.receiveBaseballNumber();
        assertThat(receiveBaseballNumber).isEqualTo(playerInput);
    }

    @DisplayName("입력 값에 문자 값 포함 또는 입력 값이 없을 경우 재입력 요청하여 NoSuchElementException 발생")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"8a7", "abc", "358a"})
    @EmptySource
    public void throw_NoSuchElementException_when_input_include_character_or_empty_value(String inputValue) {
        receivingBaseballNumber = new ReceivingBaseballNumber(new Scanner(inputValue));
        assertThrows(NoSuchElementException.class, () -> receivingBaseballNumber.receiveBaseballNumber());
    }
}