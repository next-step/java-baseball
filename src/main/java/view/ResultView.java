package view;

public class ResultView {
    public static void printBall(int count) {
        System.out.println(count + "볼");
    }

    public static void printStrike(int count) {
        System.out.println(count + " 스트라이크");
    }

    public static void printStrikeAndBall(int strikeCount, int ballCount) {
        System.out.println(strikeCount + " 스트라이크 " + ballCount + "볼");
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
