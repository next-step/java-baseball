package com.sang5c.baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseBall {

    static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String ERROR_DUPLICATED = "숫자 중복 불가";
    private static final String ERROR_LENGTH = "입력 길이가 3이 아님";

    private final List<Number> numbers;

    private BaseBall(List<Number> numbers) {
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

    public static BaseBall of(String str) {
        String[] split = str.split("");
        List<Number> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(Number.of(number));
        }
        return new BaseBall(numbers);
    }

    public static BaseBall of(List<Integer> integers) {
        List<Number> numbers = new ArrayList<>();
        for (Integer number : integers) {
            numbers.add(Number.of(number));
        }
        return new BaseBall(numbers);
    }

    public Count compare(BaseBall userBaseBall) {
        Count count = new Count();
        for (int i = 0; i < numbers.size(); i++) {
            count = countBall(userBaseBall, count, i);
            count = countStrike(userBaseBall, count, i);
        }
        return count;
    }

    private Count countStrike(BaseBall userBaseBall, Count count, int i) {
        if (numbers.get(i).equals(userBaseBall.numbers.get(i))) {
            return count.increaseStrikeCount();
        }
        return count;
    }

    private Count countBall(BaseBall userBaseBall, Count count, int i) {
        if (contains(userBaseBall, i) && !numbers.get(i).equals(userBaseBall.numbers.get(i))) {
            return count.increaseBallCount();
        }
        return count;
    }

    private boolean contains(BaseBall userBaseBall, int i) {
        return this.numbers.contains(userBaseBall.numbers.get(i));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

}
