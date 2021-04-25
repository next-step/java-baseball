import service.GameService;

import java.util.Scanner;

public class BaseballGame {
    private final static int LENGTH = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GameService gameService = new GameService();

        do {
            System.out.println("----- [ GAME START ] -----");
            gameService.initGame(LENGTH);
            System.out.print("----- [ GAME OVER ] -----" +
                    "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
        } while (Integer.parseInt(scan.next()) == 1);

    }
}
