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
        if (!isRangeNumber(this.numbers)) {
            throw new BizException(BizExceptionType.OUT_OF_BOUNDS_NUMBER);
        }
        if (isIncludeDuplicateNumber(this.numbers)) {
            throw new BizException(BizExceptionType.DUPLICATE_NUMBER);
        }
    }

    public String getNumbers() {
        return numbers;
    }

    private boolean isRangeNumber(String inputText) {
        String[] textArr = inputText.split("");
        for (String str : textArr) {
            int number = Integer.parseInt(str);
            if (number < BaseballConfiguration.MIN_NUMBER || number > BaseballConfiguration.MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncludeDuplicateNumber(String inputText) {
        HashSet<String> set = new HashSet<>();
        for (String num : inputText.split("")) {
            set.add(num);
        }
        if (set.size() != BaseballConfiguration.REQUIRED_COUNT) {
            return true;
        }
        return false;
    }


}