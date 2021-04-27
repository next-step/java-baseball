package view;

public class ResultView {

    public static final int MINIMUM_COUNT = 0;

    public static void printCountOfBallIfExist(Integer countOfBall) {
        if (countOfBall > MINIMUM_COUNT) {
            printCountOfBall(countOfBall);
        }
    }

    public static void printCountOfStrikeIfExist(Integer countOfStrike) {
        if (countOfStrike > MINIMUM_COUNT) {
            printCountOfStrike(countOfStrike);
        }
    }

    public static void printToInputWhetherToEndGameOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");
    }

    private static void printCountOfBall(Integer countOfBall) {
        System.out.println(countOfBall + " 볼");
    }

    private static void printCountOfStrike(Integer countOfStrike) {
        System.out.println(countOfStrike + " 스트라이크");
    }

    public static void printToInputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
    }
}
