package baseball.view;

public class ResultView {
    public static void printScore(int strikeCount, int ballCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + " 스트라이크 ");
        }
        if (ballCount != 0) {
            System.out.print(ballCount + " 볼");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        if (strikeCount == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
