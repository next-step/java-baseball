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
            baseballCount = countBall(userBaseball, baseballCount, i);
            baseballCount = countStrike(userBaseball, baseballCount, i);
        }
        return baseballCount;
    }

    private BaseballCount countStrike(Baseball userBaseball, BaseballCount baseballCount, int i) {
        if (numbers.get(i).equals(userBaseball.numbers.get(i))) {
            return baseballCount.increaseStrikeCount();
        }
        return baseballCount;
    }

    private BaseballCount countBall(Baseball userBaseball, BaseballCount baseballCount, int i) {
        if (contains(userBaseball, i) && !numbers.get(i).equals(userBaseball.numbers.get(i))) {
            return baseballCount.increaseBallCount();
        }
        return baseballCount;
    }

    private boolean contains(Baseball userBaseball, int i) {
        return this.numbers.contains(userBaseball.numbers.get(i));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

}
