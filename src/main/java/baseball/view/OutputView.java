package baseball.view;

import baseball.controller.dto.BaseballGameResponse;

public class OutputView {

    private static final String PRINT_NONE = "";

    public void printGameRecord(BaseballGameResponse response) {
        if (response.isFinished()) {
            printWin(response);
            return;
        }
        if (response.isNothing()) {
            printNothing();
            return;
        }
        printBallCount(response);
    }

    private void printWin(BaseballGameResponse response) {
        System.out.println(response.getStrikeCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printNothing() {
        System.out.println("낫싱");
    }

    private void printBallCount(BaseballGameResponse response) {
        System.out.println(printStrike(response.getStrikeCount()) + printBall(response.getBallCount()));
    }

    private String printStrike(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + " 스트라이크. ";
        }
        return PRINT_NONE;
    }

    private String printBall(int ballCount) {
        if (ballCount > 0) {
            return ballCount + " 볼";
        }
        return PRINT_NONE;
    }
}
