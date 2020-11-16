package com.leeha.baseball.runner;

import com.leeha.baseball.controller.BaseballGameController;

public class BaseballGameRunner {

    public static final int BALL_COUNT = 3;

    private BaseballGameController controller;

    public BaseballGameRunner() {
        this.controller = new BaseballGameController(BALL_COUNT);
    }

    public void run() {
        controller.start();
    }
}