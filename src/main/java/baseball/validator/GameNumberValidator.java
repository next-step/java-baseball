package baseball.validator;

import java.util.Objects;

import static baseball.domain.GameNumber.MAXIMUM_GAME_NUMBER;
import static baseball.domain.GameNumber.MINIMUM_GAME_NUMBER;

public class GameNumberValidator implements Validatable<Integer> {
    public static final String INVALID_GAME_NUMBER_MESSAGE = MINIMUM_GAME_NUMBER + "이상 " + MAXIMUM_GAME_NUMBER + "이하의 숫자를 입력하세요.";

    @Override
    public boolean isValid(Integer target) {
        if (Objects.isNull(target)) {
            return false;
        }

        return target >= MINIMUM_GAME_NUMBER && target <= MAXIMUM_GAME_NUMBER;
    }

    @Override
    public String getInvalidMessage() {
        return INVALID_GAME_NUMBER_MESSAGE;
    }
}
