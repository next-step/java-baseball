package com.leeha.baseball.controller.generator;

import static com.leeha.baseball.exception.BaseballGameExceptionCode.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.leeha.baseball.exception.CapacityOutOfRangeException;
import com.leeha.baseball.exception.MinimumAndMaximumRangeInvalidException;

public class BallGenerator {

    private final int capacity;
    private final int minimumNumber;
    private final int maximumNumber;

    private List<Integer> numbers;

    public BallGenerator(int capacity, int minimumNumber, int maximumNumber) {
        validateOption(capacity, minimumNumber, maximumNumber);

        this.capacity = capacity;
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
    }

    private void validateOption(int capacity, int minimumNumber, int maximumNumber) {
        if (capacity < 0) {
            throw new CapacityOutOfRangeException(INVALID_CAPACITY_EXCEPTION);
        }

        if (maximumNumber < minimumNumber) {
            throw new MinimumAndMaximumRangeInvalidException(INVALID_MINIMUM_OR_MAXIMUM_EXCEPTION);
        }
    }

    public List<Integer> generate() {
        numbers = new ArrayList<>(capacity);

        while (numbers.size() < capacity) {
            addIfEnsureCondition((number) -> !numbers.contains(number));
        }

        return numbers;
    }

    private int generateRandomNumber() {
        return new Random().nextInt((maximumNumber + 1) - minimumNumber) + minimumNumber;
    }

    private void addIfEnsureCondition(Predicate<Integer> condition) {
        int number = generateRandomNumber();

        if (condition.test(number)) {
            numbers.add(number);
        }
    }
}