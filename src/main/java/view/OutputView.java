package view;

public class OutputView {

    public static final String INFO_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String HINT_NOTING = "낫싱";
    public static final String HINT_BALL = "볼";
    public static final String HINT_STRIKE = "스트라이크";

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

    public static void printGameOver() {
        System.out.println(INFO_GAME_OVER);
    }

    public static void printNothing() {
        System.out.println(HINT_NOTING);
    }

    public static void printBallHint(int ballCnt) {
        System.out.println(ballCnt + HINT_BALL);
    }

    public static void printStrikeHint(int strikeCnt) {
        System.out.println(strikeCnt + HINT_STRIKE);
    }

    public static void printBallAndStrike(int ballCnt, int strikeCnt) {
        System.out.println(ballCnt + HINT_BALL + " " + strikeCnt + HINT_STRIKE);
    }
}
