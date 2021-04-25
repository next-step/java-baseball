package baseball;

import customtypes.UserInputValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputValidatorTest {

    private InputValidator inputValidator;

    private AbnormalInputChecker abnormalInputChecker;
    private DuplicationInputChecker duplicationInputChecker;

    @BeforeEach
    void setup() {
        this.abnormalInputChecker = mock(AbnormalInputChecker.class);
        this.duplicationInputChecker = mock(DuplicationInputChecker.class);

        this.inputValidator = new InputValidator(
                this.abnormalInputChecker,
                this.duplicationInputChecker);
    }

    @Test
    @DisplayName("입력값 검사 - 입력값이 1~9 사이의 3자리 숫자이고, 비정상 문자 체크와 중복 문자 체크를 통과한 경우 성공 리턴")
    void validate_inputIsValid_ReturnsValid(){
        // given
        String playerInput = "123";
        when(this.abnormalInputChecker.isAbnormal(any())).thenReturn(false);
        when(this.duplicationInputChecker.isDuplicated(any())).thenReturn(false);

        // when
        UserInputValidation result = this.inputValidator.validate(playerInput);

        // then
        Assertions.assertThat(result).isEqualTo(UserInputValidation.VALID);
    }

    @Test
    @DisplayName("입력값 검사 - 입력값이 3자리가 아닌 경우 오류 리턴")
    void validate_inputLenghtIsNotThree_ReturnsInvalidInputLengthFlag(){
        // given
        String playerInput = "1234";
        when(this.abnormalInputChecker.isAbnormal(any())).thenReturn(false);
        when(this.duplicationInputChecker.isDuplicated(any())).thenReturn(false);

        // when
        UserInputValidation result = this.inputValidator.validate(playerInput);

        // then
        Assertions.assertThat(result).isEqualTo(UserInputValidation.INVALID_INPUT_LENGTH);
    }

    @Test
    @DisplayName("입력값 검사 - 입력값에 비정상적인 문자가 포함된 경우 오류 리턴")
    void validate_inputHasAbnormalCharacter_ReturnsInvalidInputAbnormalChar(){
        // given
        String playerInput = "123";
        when(this.abnormalInputChecker.isAbnormal(any())).thenReturn(true);
        when(this.duplicationInputChecker.isDuplicated(any())).thenReturn(false);

        // when
        UserInputValidation result = this.inputValidator.validate(playerInput);

        // then
        Assertions.assertThat(result).isEqualTo(UserInputValidation.INVALID_INPUT_ABNORMAL_CHAR);
    }

    @Test
    @DisplayName("입력값 검사 - 입력값에 중복된 문자가 포함된 경우 오류 리턴")
    void validate_inputHasDuplicatedCharacter_ReturnsInvalidInputDuplicateChar(){
        // given
        String playerInput = "123";
        when(this.abnormalInputChecker.isAbnormal(any())).thenReturn(false);
        when(this.duplicationInputChecker.isDuplicated(any())).thenReturn(true);

        // when
        UserInputValidation result = this.inputValidator.validate(playerInput);

        // then
        Assertions.assertThat(result).isEqualTo(UserInputValidation.INVALID_INPUT_DUPLICATE_CHAR);
    }
}
