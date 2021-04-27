package baseball;

import customtypes.UserInputValidation;

public class InputValidator {
    private AbnormalInputChecker abnormalInputChecker;
    private DuplicationInputChecker duplicationInputChecker;

    private int targetLength;

    public InputValidator(
            AbnormalInputChecker abnormalInputChecker,
            DuplicationInputChecker duplicationInputChecker,
            int targetLength){
        this.abnormalInputChecker = abnormalInputChecker;
        this.duplicationInputChecker = duplicationInputChecker;

        this.targetLength = targetLength;
    }

    public UserInputValidation validate(String target) {
        if (target.length() != this.targetLength) {
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
