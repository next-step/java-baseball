package baseball.domain;

import baseball.configuration.BaseballConfiguration;
import baseball.exception.BizException;
import baseball.exception.BizExceptionType;
import baseball.util.BaseballUtil;

import java.util.HashSet;

public class BaseballNumbers {

    private String numbers;

    public BaseballNumbers(String numbers) {
        this.numbers = numbers;
    }

    public void checkValidation() {
        if (this.numbers.length() != BaseballConfiguration.REQUIRED_COUNT) {
            throw new BizException(BizExceptionType.INVALID_LENGTH);
        }
        if (!BaseballUtil.isAllNumber(this.numbers)) {
            throw new BizException(BizExceptionType.NUMBER_ONLY);
        }
        if (!isRangeNumber()) {
            throw new BizException(BizExceptionType.OUT_OF_BOUNDS_NUMBER);
        }
        if (isIncludeDuplicateNumber()) {
            throw new BizException(BizExceptionType.DUPLICATE_NUMBER);
        }
    }

    public String getNumbers() {
        return numbers;
    }

    private boolean isRangeNumber() {
        String[] textArr = this.numbers.split("");
        int nonRangeCount = 0;
        for (String str : textArr) {
            nonRangeCount += countNonRange(str);
        }
        if (nonRangeCount != 0){
            return false;
        }
        return true;
    }
    private int countNonRange(String num){
        int number = Integer.parseInt(num);
        if (number < BaseballConfiguration.MIN_NUMBER || number > BaseballConfiguration.MAX_NUMBER) {
            return 1;
        }
        return 0;
    }

    private boolean isIncludeDuplicateNumber() {
        HashSet<String> set = new HashSet<>();
        for (String num : this.numbers.split("")) {
            set.add(num);
        }
        if (set.size() != BaseballConfiguration.REQUIRED_COUNT) {
            return true;
        }
        return false;
    }


}