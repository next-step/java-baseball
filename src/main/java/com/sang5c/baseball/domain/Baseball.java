package com.sang5c.baseball.domain;

import java.util.*;

public class Baseball {

    private final List<String> numbers;

    private Baseball(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<String> numbers) {
        checkDuplicate(numbers);
        checkSize(numbers);
    }

    public static Baseball of(String str) {
        String[] split = str.split("");
        List<String> numbers = new ArrayList<>(Arrays.asList(split));
        return new Baseball(numbers);
    }

    private void checkDuplicate(List<String> numbers) {
        Set<String> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("duplicated value: " + numbers);
        }
    }

    private void checkSize(List<String> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("check input str size: " + numbers.size());
        }
    }

    public BaseballCount compare(Baseball target) {
        BaseballCount baseballCount = BaseballCount.of(0, 0);
        for (int i = 0; i < 3; i++) {
            baseballCount = checkBallCount(baseballCount, target.numbers, i);
            baseballCount = checkStrikeCount(baseballCount, target.numbers, i);
        }
        return baseballCount;
    }

    private BaseballCount checkStrikeCount(BaseballCount baseballCount, List<String> userNumbers, int index) {
        if (numbers.get(index).equals(userNumbers.get(index))) {
            return baseballCount.increaseStrikeCount();
        }
        return baseballCount;
    }

    private BaseballCount checkBallCount(BaseballCount baseballCount, List<String> userNumbers, int index) {
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
