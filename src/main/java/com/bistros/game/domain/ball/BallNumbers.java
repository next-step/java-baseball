package com.bistros.game.domain.ball;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BallNumbers {
    public static final int LENGTH = 3;

    private final List<Integer> nums;

    public List<Integer> getNums() {
        return nums;
    }

    public BallNumbers(List<Integer> nums) {
        validate(nums);
        this.nums = nums;
    }

    private void validate(List<Integer> data) {
        if (data == null || data.size() != LENGTH) {
            throw new BallNumberRuleAgainstException("게임숫자를 생성하기위한 숫자가 부족합니다");
        }

        Set<Integer> set = new HashSet<>(data);
        if (set.size() < data.size()) {
            throw new BallNumberRuleAgainstException("중복 숫자가 존재해서 게임숫자를 생성할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return nums.stream()
            .map(c -> Integer.toString(c))
            .collect(Collectors.joining());
    }

    public int isStrike(Integer userInput) {
        return nums.indexOf(userInput);
    }

    public boolean isNothing(Integer userInput) {
        return !nums.contains(userInput);
    }
}
