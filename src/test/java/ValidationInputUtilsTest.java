
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("입력 값 숫자 검증 성공")
    void validInput_Success() {
        boolean result = ValidationInputUtils.validInputNumber("123");
        assertEquals(PASS, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1233:false",
            "abcc:false",
            "111:false",
            "aaa:false",
            "1a23wda:false",
            "123:true",
            "abc:true"
    }, delimiter = ':')
    @DisplayName("입력 값에 중복 값 검증")
    void validDuplication_DuplicationString(String input, String expected) {
        boolean result = ValidationInputUtils.validInputDuplication(input);
        assertEquals(result, Boolean.valueOf(expected));
    }
}
