package game;

import game.baseball.Baseball;
import game.baseball.BaseballConstants;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        do {
            playBaseballGame();
        } while (retryGame());

    }

    public static void playBaseballGame() {
        Baseball baseball = new Baseball();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 :");
            int inputNumber = scanner.nextInt();

            baseball.makePlayerNumbers(inputNumber);
            baseball.checkStrikeAndBallCount();
            baseball.printGameResult();
        } while (baseball.isNotThreeStrike());
    }

    public static boolean retryGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == BaseballConstants.BASEBALL_RETRY_END) {
            return false;
        }
        return true;
    }
}
