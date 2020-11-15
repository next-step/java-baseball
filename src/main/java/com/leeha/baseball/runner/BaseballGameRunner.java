package com.leeha.baseball.runner;

import com.leeha.baseball.controller.BaseballGameController;

public class BaseballGameRunner {

    private BaseballGameController controller;

    public BaseballGameRunner() {
        this.controller = new BaseballGameController();
    }

    public void run() {
        controller.start();
    }
}