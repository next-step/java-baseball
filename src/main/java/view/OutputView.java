package view;

public class OutputView {

    private static final String INFO_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String HINT_NOTING = "낫싱";
    private static final String HINT_BALL = "볼";
    private static final String HINT_STRIKE = "스트라이크";

    private OutputView() {
    }

    public static void checkGameStatus(int ballCnt, int strikeCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            printNothing();
        } else if (ballCnt == 0) {
            printStrikeHint(strikeCnt);
        } else if (strikeCnt == 0) {
            printBallHint(ballCnt);
        } else {
            printBallAndStrike(ballCnt, strikeCnt);
        }
    }

    private static void printNothing() {
        System.out.println(HINT_NOTING);
    }

    private static void printBallHint(int ballCnt) {
        System.out.println(ballCnt + HINT_BALL);
    }

    private static void printBallAndStrike(int ballCnt, int strikeCnt) {
        System.out.println(ballCnt + HINT_BALL + " " + strikeCnt + HINT_STRIKE);
    }

    public static void printGameOver(int strikeCnt) {
        printStrikeHint(strikeCnt);
        System.out.println(INFO_GAME_OVER);
    }

    public static void printStrikeHint(int strikeCnt) {
        System.out.println(strikeCnt + HINT_STRIKE);
    }
}
