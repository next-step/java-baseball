package utils;

import domain.BaseballNumber;
import domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description :
 **/
public class BaseballNumberFactory {
    private static List<BaseballNumber> RAW_BASEBALL_NUMBERS = new ArrayList<>();
    private static BaseballNumbers baseballNumbers = new BaseballNumbers();

    public BaseballNumberFactory() {
        for (int i = BaseballNumbers.MINIMUM_NUMBER_OF_BASEBALL_GAME; i < BaseballNumbers.MAXIMUM_NUMBER_OF_BASEBALL_GAME + 1; i++) {
            RAW_BASEBALL_NUMBERS.add(new BaseballNumber(i));
        }
        baseballNumbers = generateNumbers();
    }

    public BaseballNumbers generateNumbers() {
        Collections.shuffle(RAW_BASEBALL_NUMBERS);
        List<BaseballNumber> shuffledAndFilteredBaseballNumber = RAW_BASEBALL_NUMBERS.subList(0, BaseballNumbers.NUMBER_OF_BASEBALL_GAME);
        baseballNumbers = new BaseballNumbers(shuffledAndFilteredBaseballNumber);
        return baseballNumbers;
    }
}
