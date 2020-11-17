package com.leeha.baseball.runner;

import java.util.Objects;
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
            start(scanner);
        }
    }

    private void start(Scanner scanner) {
        do {
            controller.start(scanner);
        } while (!end(scanner));
    }

    private boolean end(Scanner scanner) {
        BaseballGameShutdownOption operator;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            operator = BaseballGameShutdownOption.toOption(scanner.next());
        } while (Objects.isNull(operator));

        return Objects.equals(operator, BaseballGameShutdownOption.END);
    }
}