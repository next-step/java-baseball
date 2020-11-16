package baseball.process;

import baseball.bo.Opponent;
import baseball.bo.Player;

import java.util.Scanner;

public class BaseballGame {

    public void executeGame() {

        Opponent opponent = new Opponent();
        Player player = new Player();

        while (true) {

            player.inputStrikeNumber();
            opponent.calculateStrike(player.getStrikeNumber());
            System.out.println(opponent.getMessage());

            if(opponent.isLose()) {
                System.out.println("게임을 새로 시작하려면 1 종료하려면 2 를 입력하세요.");
                if(isGameEnd()) {
                    break;
                }
                opponent.resetStrikeNumber();
            }
        }
    }

    private boolean isGameEnd() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String inputData = scan.nextLine();
            if("2".equals(inputData)) {
                return true;
            }
            if("1".equals(inputData)) {
                return false;
            }
            System.out.println("1 또는 2 를 입력해 주세요.");
        }
    }
}
