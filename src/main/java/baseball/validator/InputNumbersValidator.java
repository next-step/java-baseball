package baseball.validator;

import baseball.domain.GameNumber;
import baseball.util.CollectionUtils;

import java.util.Set;

import static baseball.domain.GameNumber.MAXIMUM_GAME_NUMBER;
import static baseball.domain.GameNumber.MINIMUM_GAME_NUMBER;

public class InputNumbersValidator implements Validatable<Set<GameNumber>> {
    public static final int GAME_NUMBER_COUNT = 3;
    public static final String INVALID_INPUT_NUMBERS_MESSAGE = MINIMUM_GAME_NUMBER + "에서 " + MAXIMUM_GAME_NUMBER + "까지 중복없이 숫자 " + GAME_NUMBER_COUNT + "개를 입력하세요.";

    @Override
    public boolean isValid(Set<GameNumber> target) {
        if (CollectionUtils.isEmpty(target)) {
            return false;
        }

        return target.size() == GAME_NUMBER_COUNT;
    }

    @Override
    public String getInvalidMessage() {
        return INVALID_INPUT_NUMBERS_MESSAGE;
    }
}
