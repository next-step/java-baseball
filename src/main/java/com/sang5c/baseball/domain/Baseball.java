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

}
