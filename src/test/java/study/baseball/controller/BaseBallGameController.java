package study.baseball.controller;

import study.baseball.service.NumberGenerator;
import study.baseball.service.ResultChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGameController {
    private NumberGenerator generator;
    private ResultChecker checker;

    public BaseBallGameController() {
        this.generator = new NumberGenerator();
        this.checker = new ResultChecker();
    }

    public void gameStart() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> answerNumbers = generator.generateNumber();

        System.out.println(answerNumbers);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            // TODO : 사용자가 중복되는 숫자를 입력 못하게 막아야 함.
            // TODO : 반드시 세자리 숫자를 입력받도록 체크 해야함
            String userNumber = scanner.nextLine();

            userNumber = userNumber.trim();
            List<Integer> userNumbers = new ArrayList<>();
            for (String s : userNumber.split("")) {
                userNumbers.add(Integer.parseInt(s));
            }

            checker.setAnswerNumbers(answerNumbers);
            checker.setUserNumbers(userNumbers);
            checker.calculateResult();

            System.out.print(checker.getStrikeCount() + "스트라이크 ");
            System.out.println(checker.getBallCount() + "볼");

            if (checker.getStrikeCount() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");

                String flag = scanner.nextLine();
                if ("1".equals(flag)) {
                    answerNumbers = generator.generateNumber();
                    System.out.println(answerNumbers);

                    checker.resetGameCount();
                    checker.setAnswerNumbers(answerNumbers);
                } else {
                    break;
                }
            } else {
                checker.resetGameCount();
            }
        }
    }
}
