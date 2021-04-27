package com.baseball.domain.baseballnumber;

import java.util.List;

public class BaseBallNumberInputGenerator implements BaseballNumberGenerator {

    private List<Integer> input;

    public BaseBallNumberInputGenerator(List<Integer> input) {
        this.input = input;
    }

    @Override
    public BaseballNumber generate() {
        return new BaseballNumber(input);
    }
}
