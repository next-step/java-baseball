import java.util.Random;
import java.util.Scanner;

public class BaseBall {
    static int[] answer;
    static boolean finish;

    static boolean replay = true;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        init();
        while (replay) {
            playGame(s);
        }
        s.close();
    }

    private static void playGame(Scanner s) {
        while (!finish) {
            System.out.print("숫자를 입력해주세요 : ");
            check(s.nextLine());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        replayGame(s);
    }

    private static void replayGame(Scanner s) {
        String input = s.nextLine();
        while (!(input.equals("1") || input.equals("2"))) {
            System.out.println("올바르지 않은 입력입니다.");
            input = s.nextLine();
        }
        replay = Integer.parseInt(input) == 1;
    }


    private static void check(String input) {
        if (!isInputValid(input)) {
            System.out.println("올바르지 않은 입력입니다");
            return;
        }
        Result result = new Result();
        for (int i = 0; i < 3; i++) {
            judge(input, result, i);
        }
        showHint(result);
        finish = result.getStrikes() == 3;
    }

    private static boolean isInputValid(String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)) || !Character.isDigit(input.charAt(2))) {
            return false;
        }
        return true;
    }

    private static void showHint(Result result) {
        StringBuilder sb = new StringBuilder();
        if (result.getStrikes() != 0) {
            sb.append(String.format("%d 스트라이크 ", result.getStrikes()));
        }
        if (result.getBalls() != 0) {
            sb.append(String.format("%d 볼", result.getBalls()));
        }
        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    private static void judge(String input, Result result, int i) {
        int value = Integer.parseInt(String.valueOf(input.charAt(i)));
        if (isStrike(i, value)) {
            result.setStrikes(result.getStrikes() + 1);
        }
        if (isBall(i, value)) {
            result.setBalls(result.getBalls() + 1);
        }
    }

    private static void init() {
        finish = false;
        answer = new int[3];
        Random random = new Random(System.currentTimeMillis());
        int index = 0;
        while (index < 3) {
            index = fillNum(random, index);
        }
    }

    private static int fillNum(Random random, int index) {
        int value = random.nextInt(9) + 1;
        if (!isContain(value)) {
            answer[index] = value;
            return index + 1;
        }
        return index;
    }

    private static boolean isContain(int value) {
        return answer[0] == value || answer[1] == value || answer[2] == value;
    }

    private static boolean isStrike(int index, int value) {
        return answer[index] == value;
    }

    private static boolean isBall(int index, int value) {
        return isContain(value) && !isStrike(index, value);
    }
}
