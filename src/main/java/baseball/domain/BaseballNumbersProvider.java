package baseball.domain;

import baseball.domain.util.RandomIntegerProvider;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BaseballGameRule.*;

public class BaseballNumbersProvider {

    private static List<BaseballNumber> baseballNumbers;

    public static BaseballNumbers provideBaseballNumbers() {
        baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < COUNT_OF_BASEBALL_NUMBERS.getValue()) {
            createRandomNumber();
        }
        return new BaseballNumbers(baseballNumbers);
    }

    private static void createRandomNumber() {
        int randomNumber = RandomIntegerProvider.provideRandomNumber(MIN_NUMBER_OF_BASEBALL_NUMBER.getValue()
                , MAX_NUMBER_OF_BASEBALL_NUMBER.getValue());
        BaseballNumber baseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }
}
