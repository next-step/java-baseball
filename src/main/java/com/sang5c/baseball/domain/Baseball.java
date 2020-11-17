package com.sang5c.baseball.domain;

import java.util.*;

public class Baseball {

    static final int BASEBALL_NUMBER_LENGTH = 3;

    private final List<Number> numbers;

    private Baseball(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        checkDuplicate(numbers);
        checkSize(numbers);
    }

    public static Baseball of(String str) {
        String[] split = str.split("");
        List<Number> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Number.of(s));
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

    private void checkDuplicate(List<Number> numbers) {
        Set<Number> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("duplicated value: " + numbers);
        }
    }

    private void checkSize(List<Number> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("check input str size: " + numbers.size());
        }
    }

    public BaseballCount compare(Baseball target) {
        BaseballCount baseballCount = BaseballCount.of(0, 0);
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            baseballCount = checkBallCount(baseballCount, target.numbers, i);
            baseballCount = checkStrikeCount(baseballCount, target.numbers, i);
        }
        return baseballCount;
    }

    private BaseballCount checkStrikeCount(BaseballCount baseballCount, List<Number> userNumbers, int index) {
        if (numbers.get(index).equals(userNumbers.get(index))) {
            return baseballCount.increaseStrikeCount();
        }
        return baseballCount;
    }

    private BaseballCount checkBallCount(BaseballCount baseballCount, List<Number> userNumbers, int index) {
        if (numbers.contains(userNumbers.get(index)) && !numbers.get(index).equals(userNumbers.get(index))) {
            return baseballCount.increaseBallCount();
        }
        return baseballCount;
    }

    @Override
    public String toString() {
        return "Baseball{" +
                "numbers=" + numbers +
                '}';
    }

}
