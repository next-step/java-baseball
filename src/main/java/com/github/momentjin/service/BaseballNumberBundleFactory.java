package com.github.momentjin.service;

import com.github.momentjin.model.BaseballNumber;
import com.github.momentjin.model.BaseballNumberBundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumberBundleFactory {

    public BaseballNumberBundle generate(int bundleSize) {

        if (bundleSize > 10) {
            throw new RuntimeException("숫자묶음의 크기는 10이하이어야 합니다.");
        }

        List<BaseballNumber> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < bundleSize) {
            BaseballNumber number = generateRandomNumber();
            addBaseballNumberIfNotOverlapped(randomNumbers, number);
        }

        return new BaseballNumberBundle(randomNumbers);
    }

    private void addBaseballNumberIfNotOverlapped(List<BaseballNumber> randomNumbers, BaseballNumber number) {
        if (isNotOverlapped(randomNumbers, number)) {
            randomNumbers.add(number);
        }
    }

    private boolean isNotOverlapped(List<BaseballNumber> randomNumbers, BaseballNumber number) {
        return !randomNumbers.contains(number);
    }

    private BaseballNumber generateRandomNumber() {
        return new BaseballNumber(new Random().nextInt(10));
    }
}
