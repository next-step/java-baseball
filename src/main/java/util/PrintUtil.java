package util;

public class PrintUtil {
    public static final String INFO = "숫자를 입력해주세요 : ";

    public static void printStartInfo() {
        System.out.print(PrintUtil.INFO);
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printAskReplayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printBallHint(int ballCnt) {
        System.out.println(ballCnt + "볼");
    }

    public static void printStrikeHint(int strikeCnt) {
        System.out.println(strikeCnt + "스트라이크");
    }

    public static void printBallAndStrike(int ballCnt, int strikeCnt) {
        System.out.println(ballCnt + "볼" + " " + strikeCnt + "스트라이크");
    }
}
