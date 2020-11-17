package com.leeha.baseball.runner;

import java.util.Objects;
import java.util.Scanner;

import com.leeha.baseball.controller.BaseballGameController;
import com.leeha.baseball.controller.BaseballGameOption;

public class BaseballGameRunner {

    private static final int CAPACITY = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private BaseballGameController controller;

    public BaseballGameRunner() {
        this.controller = new BaseballGameController(new BaseballGameOption(CAPACITY, MINIMUM_NUMBER, MAXIMUM_NUMBER));
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            start(scanner);
        }
    }

    private void start(Scanner scanner) {
        do {
            controller.start(scanner);
        } while (!end(scanner));
    }

    private boolean end(Scanner scanner) {
        String shutdownCode;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            shutdownCode = scanner.next();
        } while (!BaseballGameShutdownOption.exists(shutdownCode));

        return Objects.equals(shutdownCode, BaseballGameShutdownOption.GAME_END.getCode());
    }
}
