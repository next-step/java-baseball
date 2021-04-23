package console;

import baseball.BaseBallGame;
import util.RandomNumberGenerator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.startGame();
    }

    private void playGame(BaseBallGame game, Scanner scanner) {
        while (!game.isCompleted()) {
            System.out.print("숫자를 입력해주세요 : ");
            System.out.println(game.guess(scanner.nextLine()));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (scanner.nextInt() == 1) {
            startGame();
        }
        scanner.close();
    }

    private void startGame() {
        playGame(new BaseBallGame(new RandomNumberGenerator()), new Scanner(System.in));
    }
}
