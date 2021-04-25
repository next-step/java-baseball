import java.util.*;

public class NumberBaseballGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int startOrEnd = 1;

        while (startOrEnd == 1) {
            startBaseballGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            startOrEnd = scanner.nextInt();
        }
    }

    /*
        1. 숫자야구게임시작

        1) 3자리 랜덤 숫자
        2) 값 입력
        3) 3스트라이크까지 반복
     */
    public static void startBaseballGame() {
        int random = makeRandomNumber();
        boolean isContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (isContinue) {
            System.out.print("숫자를 입력해주세요 : ");
            isContinue = printResult(random, scanner.nextInt());
        }
    }

    /*
        2. 1부터 9까지 서로 다른 임의 수로 3자리 난수생성

        1) 3개의 서로 다른 임의 숫자
        2) 3자리수로 변환
        @Return 서로 다른 임의의 수로 이루어진 3자리 난수
     */
    public static int makeRandomNumber() {
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() < 3) {
            randomSet.add((int) (Math.random() * (9 - 1)) + 1);
        }

        int random = 0;
        int digits = 100;

        for (Integer integer : randomSet) {
            random += integer * digits;
            digits /= 10;
        }

        return random;
    }

    /*
        3. 스트라이크와 볼에 따른 메세지 출력
        @Return 게임 지속여부
     */
    public static boolean printResult(int random, int input) {

        return true;
    }

    /*
        4. 스트라이크 카운트
        @Return 스트라이크 카운트
     */
    public static int countStrike(int random, int input) {
        int strike = 0;

        return strike;
    }

    /*
        5. 볼 카운트
        @Return 볼 카운트
     */
    public static int countBall(int random, int input) {
        int ball = 0;

        return ball;
    }
}
