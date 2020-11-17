package com.sang5c.baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Numbers {

    private final List<String> numbers;

    private Numbers(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<String> numbers) {
        checkDuplicate(numbers);
        checkSize(numbers);
    }

    private void checkDuplicate(List<String> numbers) {
        HashSet<String> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자 중복 불가");
        }
    }

    private void checkSize(List<String> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력 길이가 3이 아님");
        }
    }

    public static Numbers of(String str) {
        String[] split = str.split("");
        return new Numbers(Arrays.asList(split.clone()));
    }

    public Count compare(Numbers userNumbers) {
        Count count = new Count(0, 0);

        for (int i = 0; i < numbers.size(); i++) {
            count = countBall(userNumbers, count, i);
            count = countStrike(userNumbers, count, i);
        }
        return count;
    }

    private Count countStrike(Numbers userNumbers, Count count, int i) {
        if (numbers.get(i).equals(userNumbers.numbers.get(i))) {
            return count.increaseStrikeCount();
        }
        return count;
    }

    private Count countBall(Numbers userNumbers, Count count, int i) {
        if (contains(userNumbers, i) && !numbers.get(i).equals(userNumbers.numbers.get(i))) {
            return count.increaseBallCount();
        }
        return count;
    }

    private boolean contains(Numbers userNumbers, int i) {
        return this.numbers.contains(userNumbers.numbers.get(i));
    }

}
