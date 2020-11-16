package com.leeha.baseball.controller;

import java.util.List;

public class BaseballGameController {

    private BallGenerator generator;

    public BaseballGameController(int ballCount) {
        generator = new BallGenerator(ballCount);
    }

    public void start() {
        List<Integer> numbers = generator.generate();
    }
}