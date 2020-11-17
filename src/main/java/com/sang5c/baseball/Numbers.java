package com.sang5c.baseball;

import java.util.ArrayList;
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

        // for (int i = 0; i < userStrings.size(); i++) {
        //     if (questionStrings.contains(userStrings.get(i))) {
        //         if (questionStrings.get(i).equals(userStrings.get(i))) {
        //             count = count.increaseStrikeCount();
        //             continue;
        //         }
        //         count = count.increaseBallCount();
        //     }
        // }

        return count;
    }

}
