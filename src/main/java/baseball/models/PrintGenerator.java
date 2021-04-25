package baseball.models;

import baseball.ui.FastScanner;

public class PrintGenerator {

    private final FastScanner fs = FastScanner.of();

    private final NumValidChecker numValidChecker;
    private final Calculator calculator;

    public PrintGenerator(NumValidChecker numValidChecker, Calculator calculator) {
        this.numValidChecker = numValidChecker;
        this.calculator = calculator;
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해 주세요:");
        String input = fs.next();

        numValidChecker.isNumber(input);
        numValidChecker.isThreeSize(input);
        return input;
    }

    public Integer[] printAndGetStrikeOrBall(String random, String input) {
        Integer[] result = calculator.calculateStrikesBallsOrNothing(random, input);
        System.out.println(showResult(result[0], result[1]));
        return result;
    }


    public void Exited() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public String showResult(int strike, int ball) {
        return (strike == 0 && ball == 0) ? "낫싱" :
                (strike > 0 ? strike + " 스트라이크" : "") +
                        (ball > 0 ? ball + " 볼" : "");
    }
}
