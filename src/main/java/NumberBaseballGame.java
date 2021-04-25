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
        if (Integer.toString(input).indexOf('0') > -1) {
            System.out.println("0은 포함 할 수 없습니다.");
            return true;
        }
        if (input > 999) {
            System.out.println("3자리까지 입력 가능합니다.");
            return true;
        }

        int strike = countStrike(random, input);
        int ball = countBall(random, input);

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return false;
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
        }

        System.out.println();

        return true;
    }

    /*
        4. 스트라이크 카운트
        @Return 스트라이크 카운트
     */
    public static int countStrike(int random, int input) {
        int strike = 0;

        while (input > 0) {
            strike += random % 10 == input % 10 ? 1 : 0;
            random /= 10;
            input /= 10;
        }

        return strike;
    }

    /*
        5. 볼 카운트
        @Return 볼 카운트
     */
    public static int countBall(int random, int input) {
        int ball = 0;

        List<Integer> randomList = new ArrayList<>();
        List<Integer> inputList = new ArrayList<>();

        while (input > 0) {
            randomList.add(random % 10);
            inputList.add(input % 10);

            random /= 10;
            input /= 10;
        }

        for (int i = 0; i < inputList.size(); i++) {
            ball += isBall(randomList, inputList, i) ? 1 : 0;
        }

        return ball;
    }

    /*
        6. 볼 여부 판단
        @Return 볼 여부
     */
    public static boolean isBall(List<Integer> randomList, List<Integer> inputList, int i) {
        return false;
    }
}
