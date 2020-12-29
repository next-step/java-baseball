import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isFinal = false;
        while (!isFinal) {
            BaseballGame game = new BaseballGame();
            game.setRandomNumber();
            game.runGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isFinal = sc.nextInt() == 2;
        }
    }
}
