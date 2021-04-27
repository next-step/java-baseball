package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
    private final BaseballNumberScanner baseballNumberScanner = new BaseballNumberScanner();
    private final BaseballResultPrinter baseballResultPrinter = new BaseballResultPrinter();
    private BaseballRule baseballRule;
    private List<Integer> example;
    private List<Integer> answer;
    private int restart;

    private void init() {
        example = baseballNumberGenerator.generate();
        baseballRule = new BaseballRule(example);
        restart = -1;
    }

    private void goPlateAppearance() {
        answer = baseballNumberScanner.getNumber();
        baseballRule.setAnswer(answer);
        baseballRule.checkNumbers();
        baseballResultPrinter.printResult(baseballRule);
    }

    private int stringToInteger(String input) {
        int result = -1;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("숫자를 입력하세요.");
        }
        return result;
    }

    private void continueGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Scanner scan = new Scanner(System.in);

        while(restart != 1 && restart != 2) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scan.next();
            restart = stringToInteger(input);
        }
    }

    public int getRestart() {
        return restart;
    }

    public void startGame() {
        init();
        do {
            goPlateAppearance();
        } while(baseballRule.getStrike() != 3);

        continueGame();
    }
}
