package com.leeha.baseball.controller.generator;

import static com.leeha.baseball.exception.BaseballGameExceptionCode.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.leeha.baseball.exception.InvalidCapacityException;
import com.leeha.baseball.exception.InvalidMinimumOrMaximumException;

public class BallGenerator {

    private final int capacity;
    private final int minimumNumber;
    private final int maximumNumber;

    private List<Integer> numbers;

    public BallGenerator(int capacity, int minimumNumber, int maximumNumber) {
        validateParameter(capacity, minimumNumber, maximumNumber);

        this.capacity = capacity;
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
    }

    private void validateParameter(int capacity, int minimumNumber, int maximumNumber) {
        if (capacity < 0) {
            throw new InvalidCapacityException(INVALID_CAPACITY_EXCEPTION);
        }

        if (maximumNumber < minimumNumber) {
            throw new InvalidMinimumOrMaximumException(INVALID_MINIMUM_OR_MAXIMUM_EXCEPTION);
        }
    }

    public List<Integer> generate() {
        numbers = new ArrayList<>(capacity);

        while (numbers.size() < capacity) {
            addIfEnsureCondition(number -> !numbers.contains(number));
        }

        return Collections.unmodifiableList(numbers);
    }

    private int generateRandomNumber() {
        return new Random().nextInt((maximumNumber + 1) - minimumNumber) + minimumNumber;
    }

    private void addIfEnsureCondition(BallConditionPredicate<Integer> condition) {
        int number = generateRandomNumber();

        if (condition.test(number)) {
            numbers.add(number);
        }
    }
}
