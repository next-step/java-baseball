package baseball.validator;

import java.util.Objects;

import static baseball.validator.InputNumbersValidator.GAME_NUMBER_COUNT;

public class TrialResultValidator implements Validatable<Integer> {
    public static final String INVALID_TRIAL_RESULT_MESSAGE = "잘못된 결과입니다.";

    @Override
    public boolean isValid(Integer target) {
        if (Objects.isNull(target)) {
            return false;
        }

        return target >= 0 && target <= GAME_NUMBER_COUNT;
    }

    @Override
    public String getInvalidMessage() {
        return INVALID_TRIAL_RESULT_MESSAGE;
    }
}

