package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private static final int NUMBER_LENGTH = 3;
    private String number;

    public BaseballNumber(String number) {
        checkLength(number);
        checkZero(number);
        checkDuplicate(number);
        this.number = number;
    }

    private void checkLength(String number) {
        if (number.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 " + NUMBER_LENGTH + "개만 입력해주세요.");
        }
    }

    private void checkZero(String number) {
        if (number.contains("0")) {
            throw new IllegalArgumentException("0이 들어있습니다.");
        }
    }

    private void checkDuplicate(String number) {
        Set<String> numbers = new HashSet<>();
        List<String> splitList = Arrays.asList(number.split(""));
        for (String s : splitList) {
            numbers.add(s);
        }

        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
    }

    public String getNumber() {
        return number;
    }
}
