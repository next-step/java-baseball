package com.leeha.baseball.controller;

import java.util.List;
import java.util.Scanner;

import com.leeha.baseball.controller.generator.BallGenerator;
import com.leeha.baseball.controller.validator.BallValidator;

public class BaseballGameController {

    private final BallGenerator generator;
    private final BallValidator validator;

    public BaseballGameController(BaseballGameOption options) {
        generator = new BallGenerator(
            options.getBallCount(),
            options.getMinimumBallNumber(),
            options.getMaximumBallNumber());
        validator = new BallValidator(
            options.getBallCount(),
            options.getMinimumBallNumber(),
            options.getMaximumBallNumber());
    }

    public void start(Scanner scanner) {
        List<Integer> numbers = generator.generate();
        String answer = readAnswer(scanner);
    }

    private String readAnswer(Scanner scanner) {
        String answer;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            answer = scanner.next();
        } while (!validator.validate(answer));

        return answer;
    }
}