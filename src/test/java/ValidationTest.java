import domain.ValidationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {
    Validation validation = new Validation();

    @Test
    @DisplayName("숫자입력 검증")
    void validationNumberPitchingTest() {
        String pitching = "123";

        boolean isNumeric =  pitching.matches("^[1-9]*$");
        assertEquals(true, isNumeric);
    }

    @Test
    @DisplayName("숫자입력(0) 검증")
    void validationExceptZeroPitchingTest() {
        String pitching = "023";

        boolean isNumeric =  pitching.matches("^[1-9]*$");
        assertEquals(false, isNumeric);
    }

    @Test
    @DisplayName("3자리까지만 입력 검증")
    void validationNumberofCharactersTest() {
        String pitching = "1234567";
        ValidationResult validationResult = validation.validationPitching(pitching);
        assertEquals("1~9 숫자 3자리 입력 가능합니다. 다시 입력해주세요.", validationResult.getMessage());
    }

    @Test
    @DisplayName("1~9 숫자만 입력 검증")
    void validationOnlyNumberofCharactersTest() {
        String pitching = "00s";
        ValidationResult validationResult = validation.validationPitching(pitching);
        assertEquals("1~9 숫자만 입력 가능합니다. 다시 입력해주세요.", validationResult.getMessage());
    }

    @Test
    @DisplayName("중복 숫자 불가 검증")
    void validationDuplicateNumberofCharactersTest() {
        String pitching = "111";
        ValidationResult validationResult = validation.validationPitching(pitching);
        assertEquals("중복하지 않는 숫자로 다시 입력해주세요.", validationResult.getMessage());
    }
}
