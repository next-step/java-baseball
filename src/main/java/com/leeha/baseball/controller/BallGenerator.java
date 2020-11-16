package com.leeha.baseball.controller;

import static com.leeha.baseball.exception.BaseballGameExceptionCode.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.leeha.baseball.exception.CapacityOutOfRangeException;

public class BallGenerator {

    public final static int MINIMUM_NUMBER = 1;
    public final static int MAXIMUM_NUMBER = 9;

    private final int capacity;

    private List<Integer> numbers;

    public BallGenerator(int capacity) throws CapacityOutOfRangeException {
        if (capacity < MINIMUM_NUMBER || capacity > MAXIMUM_NUMBER) {
            throw new CapacityOutOfRangeException(CAPACITY_OUT_OF_RANGE_EXCEPTION);
        }

        this.capacity = capacity;
    }

    public List<Integer> generate() {
        numbers = new ArrayList<>(capacity);

        while (numbers.size() < capacity) {
            addNonDuplicatedNumber();
        }

        return numbers;
    }

    private void addNonDuplicatedNumber() {
        int number = generateRandomNumber();

        if (!isDuplicatedNumber(number)) {
            numbers.add(number);
        }
    }

    private int generateRandomNumber() {
        return new Random().nextInt((MAXIMUM_NUMBER + 1) - MINIMUM_NUMBER) + MINIMUM_NUMBER;
    }

    private boolean isDuplicatedNumber(int number) {
        return numbers.contains(number);
    }
}