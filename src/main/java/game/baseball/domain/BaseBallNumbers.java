package game.baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static game.baseball.domain.BaseBallMessage.*;

public class BaseBallNumbers {

    public static final int NUMBER_OF_DIGITS = 3;

    private final List<BaseBallNumber> numbers;

    public BaseBallNumbers() {
        numbers = BaseBallNumberGenerator.shuffleAndGet();
    }

    public BaseBallNumbers(String number) {
        checkArgument(number.length() == NUMBER_OF_DIGITS, BASEBALL_LENGTH);
        checkArgument(number.indexOf('0') == -1, NOT_ALLOWED_ZERO);

        Set<BaseBallNumber> numberSet = new LinkedHashSet<>();
        for (char ch : number.toCharArray()) {
            checkArgument(Character.isDigit(ch), ONLY_ALLOW_NUMBER);
            numberSet.add(BaseBallNumber.of(Character.getNumericValue(ch)));
        }
        numbers = new ArrayList<>(numberSet);

        checkArgument(numbers.size() == NUMBER_OF_DIGITS, HAS_DUPLICATE);
    }

    public Decision getDecisionResult(BaseBallNumber baseBallNumber, int position) {
        if (numbers.indexOf(baseBallNumber) == position) {
            return Decision.STRIKE;
        }

        if (numbers.contains(baseBallNumber)) {
            return Decision.BALL;
        }

        return Decision.NONE;
    }

    public BaseBallNumber get(int index) {
        return numbers.get(index);
    }

    public NumberHint getHint(BaseBallNumbers baseBallNumbers) {
        List<Decision> decisions = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            decisions.add(getDecisionResult(baseBallNumbers.get(i), i));
        }
        return new NumberHint(decisions);
    }
}
