package baseball.process;

import baseball.bo.Opponent;
import baseball.bo.Player;

import java.util.Scanner;

public class BaseballGame {

    private final String GAME_RESTART = "1";
    private final String GAME_END = "2";

    public void executeGame() {

        Opponent opponent = new Opponent();
        Player player = new Player();

        do {

            player.inputStrikeNumber();
            opponent.calculateStrike(player.getStrikeNumber());
            System.out.println(opponent.getMessage());

        } while (this.isGameEnd(opponent));
    }

    private boolean isGameEnd(Opponent opponent) {
        return opponent.isLose() && exitGame(opponent);
    }

    private boolean exitGame(Opponent opponent) {

        System.out.println("게임을 새로 시작하려면 1 종료하려면 2 를 입력하세요.");
        Scanner scan = new Scanner(System.in);

        while (true) {
            String inputData = scan.nextLine();
            if(GAME_END.equals(inputData)) {
                return true;
            }
            if(GAME_RESTART.equals(inputData)) {
                opponent.resetStrikeNumber();
                return false;
            }
            System.out.println("1 또는 2 를 입력해 주세요.");
        }
    }
}
