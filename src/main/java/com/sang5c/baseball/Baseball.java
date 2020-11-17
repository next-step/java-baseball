package com.sang5c.baseball;

import java.util.*;

public class Baseball {

    private final List<String> numbers;

    public Baseball(String s) {
        String[] split = s.split("");
        List<String> numbers = new ArrayList<>(Arrays.asList(split));
        checkDuplicate(numbers);
        checkSize(numbers);

        this.numbers = numbers;
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
