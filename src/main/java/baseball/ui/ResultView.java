package baseball.ui;

import baseball.domain.PitchResult;

public class ResultView {
    private static final String MESSAGE_STRIKE = "스트라이크 ";
    private static final String MESSAGE_BALL = "볼 ";
    private static final String MESSAGE_NO_COUNT = "낫싱";
    private static final String MESSAGE_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printPlayResult(PitchResult pitchResult) {
        printStrike(pitchResult);
        printBall(pitchResult);
        printNoCount(pitchResult);
        System.out.println();
    }

    private static void printStrike(PitchResult pitchResult) {
        if (pitchResult.isExistsStrike()) {
            System.out.print(pitchResult.strike() + MESSAGE_STRIKE);
        }
    }

    private static void printBall(PitchResult pitchResult) {
        if (pitchResult.isExistsBall()) {
            System.out.print(pitchResult.ball() + MESSAGE_BALL);
        }
    }

    private static void printNoCount(PitchResult pitchResult) {
        if (!pitchResult.isExistsStrike() && !pitchResult.isExistsBall()) {
            System.out.print(MESSAGE_NO_COUNT);
        }
    }

    public static void printEndGame() {
        System.out.println(MESSAGE_END_GAME);
    }
}
