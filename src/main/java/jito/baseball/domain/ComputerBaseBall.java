package jito.baseball.domain;

import jito.baseball.message.ErrorMessage;
import jito.baseball.util.BaseballException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerBaseBall implements NumberBaseBall {

    private static final int DEFAULT_MINIMUM = 1;
    private static final int DEFAULT_MAXIMUM = 9;
    private static final int SIZE = 3;

    private int[] computerNumbers;

    public ComputerBaseBall() {}

    public int[] getComputerNumbers() {
        return computerNumbers;
    }

    public void makeBaseBall() {
        List<Integer> mixedList = makeMixedList();
        computerNumbers = makeRangeArray(mixedList);
        checkValidation();
    }

    private List<Integer> makeMixedList() {
        List<Integer> list = new ArrayList<>();
        for (int i = DEFAULT_MINIMUM; i <= DEFAULT_MAXIMUM; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private int[] makeRangeArray(List<Integer> list) {
        int[] computerNumbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            computerNumbers[i] = list.get(i);
        }
        return computerNumbers;
    }

    @Override
    public void isNotOneToNineNumber() {
        for (int number : computerNumbers) {
            if (number < 1 || number > 9) {
                BaseballException.throwException(ErrorMessage.EACH_NUMBER_RANGE_ERROR);
            }
        }
    }

    @Override
    public void isNotThreeDigits() {
        if (computerNumbers.length != 3) {
            BaseballException.throwException(ErrorMessage.DIGITS_ERROR);
        }
    }

    @Override
    public void isDuplicate() {
        if ((computerNumbers[0] == computerNumbers[1] || computerNumbers[0] == computerNumbers[2]) || computerNumbers[1] == computerNumbers[2]) {
            BaseballException.throwException(ErrorMessage.DUPLICATE_ERROR);
        }
    }

    @Override
    public void checkValidation() {
        isNotOneToNineNumber();
        isNotThreeDigits();
        isDuplicate();
    }
}
