package game.baseball;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static game.baseball.BaseBallMessage.*;

public class BaseBallNumbers {

    public static final int NUMBER_OF_DIGITS = 3;

    private final List<BaseBallNumber> numbers;

    public BaseBallNumbers() {
        numbers = BaseBallNumberGenerator.shuffleAndGet();
    }

    public BaseBallNumbers(String number) {
        checkArgument(number.length() == NUMBER_OF_DIGITS, BASEBALL_LENGTH);
        checkArgument(number.indexOf('0') == -1, NOT_ALLOWED_ZERO);

        Set<BaseBallNumber> numberSet = new HashSet<>();
        for (char ch : number.toCharArray()) {
            checkArgument(Character.isDigit(ch), ONLY_ALLOW_NUMBER);
            numberSet.add(BaseBallNumber.of(Character.getNumericValue(ch)));
        }
        numbers = new ArrayList<>(numberSet);

        checkArgument(numbers.size() == NUMBER_OF_DIGITS, HAS_DUPLICATE);
    }

    public boolean isStrike(BaseBallNumber baseBallNumber, int position) {
        return match(baseBallNumber, position);
    }

    public boolean isBall(BaseBallNumber baseBallNumber, int position) {
        // TODO 인덴트 1만 허용
        for (int i = 0; i < numbers.size(); i++) {
            if (i != position && match(baseBallNumber, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(BaseBallNumber baseBallNumber, int position) {
        return numbers.get(position)
            .equals(baseBallNumber);
    }
}
