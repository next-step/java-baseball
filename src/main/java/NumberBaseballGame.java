import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {
        startBaseballGame();

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) {
            startBaseballGame();
        }
    }

    /*
        숫자야구게임시작
        1. 3자리 랜덤 숫자
        2. 값 입력
        3. 3스트라이크까지 반복
     */
    public static void startBaseballGame() {
        int number = (int) (Math.random() * 1000);
        boolean isContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (isContinue) {
            System.out.print("숫자를 입력해주세요 : ");
            isContinue = printResult(number, scanner.nextInt());
        }
    }

    /*
        스트라이크와 볼에 따른 메세지 출력
     */
    public static boolean printResult(int number, int input) {

        return true;
    }

    /*
        스트라이크 카운트
        1. 스트라이크 카운트 리턴
     */
    public static int countStrike(int number, int input) {
        int strike = 0;

        return strike;
    }

    /*
        볼 카운트
        1. 볼 리턴
     */
    public static int countBall(int number, int input) {
        int ball = 0;

        return ball;
    }
}
