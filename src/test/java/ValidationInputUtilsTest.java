import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ValidationInputUtilsTest {
    private final boolean PASS = true;

    @Test
    @DisplayName("숫자 이외 값 입력 불가능")
    void validInput_NoANumeric() {
        boolean result = ValidationInputUtils.validInputNumber("가나다");
        assertNotEquals(PASS, result);
    }

    @Test
    @DisplayName("N 자리 수만 입력 가능")
    void validInput_LengthError() {
        boolean result = ValidationInputUtils.validInputNumber("124523");
        assertNotEquals(PASS, result);
    }

    @Test
    @DisplayName("입력 값 검증 성공")
    void validInput_Success() {
        boolean result = ValidationInputUtils.validInputNumber("123");
        assertEquals(PASS, result);
    }
}
