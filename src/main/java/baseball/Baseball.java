package baseball;

import java.util.*;

public class Baseball {

    private static String answer = "";
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static int strike;
    private static int ball;

    public static void main(String[] args) {
        while (true) {
            initGame();

            playGame();

            endGame();
        }
    }

    private static void initGame() {
        answer = "";
        random.setSeed(System.currentTimeMillis());

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        while (set.size() != 3) {
            set.add(random.nextInt(9) + 1);
        }

        for (int number : set) {
            answer += number;
        }
    }

    private static void playGame() {
        String input = "";

        while (!input.equals(answer)) {
            strike = 0;
            ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.nextLine();

            submitInput(input);
            printResult();
        }
    }

    private static void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0 && ball == 0) {
            System.out.println(String.format("%d 스트라이크", strike));
            return;
        }

        if (strike == 0 && ball > 0) {
            System.out.println(String.format("%d 볼", ball));
            return;
        }

        if (strike > 0 && ball > 0) {
            System.out.println(String.format("%d 스트라이크 %d 볼", strike, ball));
        }
    }

    private static void submitInput(String input) {
        for (int i=0; i < input.length(); i++) {
            validateChar(i, input.charAt(i));
        }
    }

    private static void validateChar(int index, char number) {
        int location = answer.indexOf(number);

        if (location == index) {
            strike += 1;
            return;
        }

        if (location > -1) {
            ball += 1;
            return;
        }
    }

    private static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int command = scanner.nextInt();
        scanner.nextLine();

        if (command == 1) {
            return;
        }

        if (command == 2) {
            System.exit(0);
        }
    }
}
