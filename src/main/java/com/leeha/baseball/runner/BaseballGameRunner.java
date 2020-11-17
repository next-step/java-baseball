package com.leeha.baseball.runner;

import java.util.Scanner;

import com.leeha.baseball.controller.BaseballGameController;
import com.leeha.baseball.controller.GameOption;

public class BaseballGameRunner {

    private BaseballGameController controller;

    public BaseballGameRunner() {
        this.controller = new BaseballGameController(new GameOption(3, 1, 9));
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            controller.start(scanner);
        }
    }
}