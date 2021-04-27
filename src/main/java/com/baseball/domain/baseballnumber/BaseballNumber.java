package com.baseball.domain.baseballnumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    public static final int SIZE = 3;

    private List<Integer> baseballNumbers;

    public BaseballNumber(List<Integer> input) {
        validateSize(input);
        validateZero(input);
        validateDuplicate(input);
        this.baseballNumbers = input;
    }

    private void validateSize(List<Integer> input) {
        if (input.size() != SIZE) {
            throw new IllegalArgumentException("야구 숫자는 3자리 수만 가능합니다.");
        }
    }

    private void validateZero(List<Integer> input) {
        if (input.contains(0)) {
            throw new IllegalArgumentException("야구 숫자는 1~9 까지 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> input) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(input);
        if (nonDuplicateNumbers.size() != SIZE) {
            throw new IllegalArgumentException("야구 숫자는 중복될 수 없습니다.");
        }
    }

    public int getBaseballNumberByIndex(int index) {
        return baseballNumbers.get(index);
    }

    public boolean contains(int number) {
        return baseballNumbers.contains(number);
    }

    public boolean isSameNumberByIndex(int number, int index) {
        return (number == baseballNumbers.get(index)) ? true : false;
    }

}
