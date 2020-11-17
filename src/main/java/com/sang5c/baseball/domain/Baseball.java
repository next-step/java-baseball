package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Baseball {

    static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String ERROR_DUPLICATED = "숫자 중복 불가";
    private static final String ERROR_LENGTH = "입력 길이가 3이 아님";

    private final List<Number> numbers;

    private Baseball(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        checkDuplicate(numbers);
        checkSize(numbers);
    }

    private void checkDuplicate(List<Number> numbers) {
        HashSet<Number> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED);
        }
    }

    private void checkSize(List<Number> numbers) {
        if (numbers.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    public static Baseball of(String str) {
        String[] split = str.split("");
        List<Number> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(Number.of(number));
        }
        return new Baseball(numbers);
    }

    public static Baseball of(List<Integer> integers) {
        List<Number> numbers = new ArrayList<>();
        for (Integer number : integers) {
            numbers.add(Number.of(number));
        }
        return new Baseball(numbers);
    }

    public BaseballCount compare(Baseball userBaseball) {
        BaseballCount baseballCount = new BaseballCount();
        for (int i = 0; i < numbers.size(); i++) {
            baseballCount = countBall(userBaseball.numbers, baseballCount, i);
            baseballCount = countStrike(userBaseball.numbers, baseballCount, i);
        }
        return baseballCount;
    }

    private BaseballCount countStrike(List<Number> userNumbers, BaseballCount baseballCount, int i) {
        if (numbers.get(i).equals(userNumbers.get(i))) {
            return baseballCount.increaseStrikeCount();
        }
        return baseballCount;
    }

    private BaseballCount countBall(List<Number> userNumbers, BaseballCount baseballCount, int i) {
        if (contains(userNumbers.get(i)) && !numbers.get(i).equals(userNumbers.get(i))) {
            return baseballCount.increaseBallCount();
        }
        return baseballCount;
    }

    private boolean contains(Number number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

}
