package com.leeha.baseball.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.leeha.baseball.controller.generator.BallGenerator;
import com.leeha.baseball.controller.inspector.BaseballGameInspector;
import com.leeha.baseball.controller.validator.BallValidator;

public class BaseballGameController {

    private final BallGenerator generator;
    private final BallValidator validator;
    private final BaseballGameInspector inspector;

    public BaseballGameController(GameOption options) {
        generator = new BallGenerator(
            options.getBallCount(),
            options.getMinimumBallNumber(),
            options.getMaximumBallNumber());
        validator = new BallValidator(
            options.getBallCount(),
            options.getMinimumBallNumber(),
            options.getMaximumBallNumber());
        inspector = new BaseballGameInspector();
    }

    public void start(Scanner scanner) {
        List<Integer> balls = generator.generate();
        String answer;
        do {
            answer = readAnswer(scanner);
        } while (!inspector.inspect(balls, splitAnswer(answer)));
    }

    private List<String> splitAnswer(String answer) {
        return Arrays.asList(answer.split(""));
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