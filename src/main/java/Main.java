import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("게임 시작:1, 종료:0");
        while (scanner.nextInt() == 1) {
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.start();
            System.out.println("게임 종료:0, 다시 시작:1");
        }
    }
}
