import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        runGame();
        while (runNewGame()) {
            runGame();
        }
    }

    public static void runGame() {
        String source = RandomString.generate(3);
        boolean finished = false;
        while (!finished) {
            finished = gameFinished(source);
        }
    }

    public static String getTarget(String source) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요:");
        String target = scanner.nextLine();
        while (source.length() != target.length()) {
            System.out.print("숫자를 다시 입력해주세요:");
            target = scanner.nextLine();
        }
        return target;
    }

    public static boolean gameFinished(String source) {
        int strike = 0;
        int ball = 0;
        String target = getTarget(source);
        for (int i = 0; i < 3; i++) {
            strike += calculateStrike(target.charAt(i), source.charAt(i));
            // strike 인 경우에도 ball을 무조건 계산해야하는 비효율 존재
            ball += calculateBall(source, target, i);
        }
        return finished(strike, ball);
    }
    public static boolean finished(int strike, int ball){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }

        printGameResult(strike, ball);
        return false;
    }

    public static int calculateStrike(char source, char target) {
        if (source == target) {
            return 1;
        }
        return 0;
    }

    public static int calculateBall(String source, String target, int index) {
        if (source.substring(0, index).contains(target.substring(index, index + 1))) {
            return 1;
        }
        if (source.substring(index + 1).contains(target.substring(index, index + 1))) {
            return 1;
        }
        return 0;
    }

    public static boolean runNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().equals("1");
    }

    public static void printGameResult(int strike, int ball) {
        if (strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

}
