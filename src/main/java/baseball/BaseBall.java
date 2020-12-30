package baseball;

import java.util.List;

public class BaseBall {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final NumberScanner numberScanner = new NumberScanner();
    private final Checker checker = new Checker();

    public void start() {
        List<Integer> computer = numberGenerator.generate();

        while (!guess(computer));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean guess(List<Integer> computer) {
        System.out.print("숫자를 입력해주세요: ");
        List<Integer> user = numberScanner.scan();

        return getResult(computer, user);
    }

    public boolean getResult(List<Integer> computer, List<Integer> user) {
        int strike = checker.checkStrike(computer, user);
        int ball = checker.checkBall(computer, user);
        System.out.println(makeHindStr(strike, ball));

        if (strike == 3) {
            return true;
        }

        return false;
    }

    public String makeHindStr(int strike, int ball) {
        if (strike == 0) {
            return String.format("%d볼", ball);
        }
        if (ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        return String.format("%d스트라이크 %d볼", strike, ball);
    }
}
