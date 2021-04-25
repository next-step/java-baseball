package baseball;

import customtypes.UserInputValidation;

public class InputValidator {
    private AbnormalInputChecker abnormalInputChecker;
    private DuplicationInputChecker duplicationInputChecker;

    public InputValidator(){
        this.abnormalInputChecker = new AbnormalInputChecker();
        this.duplicationInputChecker = new DuplicationInputChecker();
    }

    public UserInputValidation validate(String target) {
        if (target.length() != 3) {
            return UserInputValidation.INVALID_INPUT_LENGTH;
        }

        return this.validateChars(target.toCharArray());
    }

    private UserInputValidation validateChars(char[] targetChars) {
        if (this.abnormalInputChecker.isAbnormal(targetChars)) {
            return UserInputValidation.INVALID_INPUT_ABNORMAL_CHAR;
        }

        if (this.duplicationInputChecker.isDuplicated(targetChars)) {
            return UserInputValidation.INVALID_INPUT_DUPLICATE_CHAR;
        }

        return UserInputValidation.VALID;
    }
}
