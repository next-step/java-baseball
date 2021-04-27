import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InputHandlerTest {
    private InputHandler inputHandler = new InputHandler();

    @Test()
    void assertSplitInput() {
        int num = 103;
        assertThat(inputHandler.splitInput(num)).isEqualTo(Lists.newArrayList(1, 0, 3));
    }

    @Test()
    void assertIsValidateInputList() {
        List zeroDigit = Lists.newArrayList(2, 1, 0);
        assertThat(inputHandler.isValidateInputList(zeroDigit)).isFalse();
        List duplicatedDigit = Lists.newArrayList(2, 1, 1);
        assertThat(inputHandler.isValidateInputList(duplicatedDigit)).isFalse();
        List correctInput = Lists.newArrayList(7, 1, 3);
        assertThat(inputHandler.isValidateInputList(correctInput)).isTrue();
    }

    @Test()
    void assertIsValidateInputRange() {
        int bigInt = 1000;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            inputHandler.isValidateInputRange(bigInt);
        }).withMessage("숫자는 3자리 수여야 합니다.");
        int smallInt = 10;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            inputHandler.isValidateInputRange(smallInt);
        }).withMessage("숫자는 3자리 수여야 합니다.");
        int correctInt = 100;
        assertThatNoException().isThrownBy(() -> {
            inputHandler.isValidateInputRange(correctInt);
        });
    }
}