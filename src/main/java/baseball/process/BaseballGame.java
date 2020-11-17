package baseball.process;

import baseball.bo.Opponent;
import baseball.bo.Player;
import baseball.enums.UserCommandEnum;

import java.util.Scanner;

public class BaseballGame {

    Opponent opponent;
    Player player;

    private void initPlayer() {
        opponent = new Opponent();
        player = new Player();
    }

    public void executeGame() {
        initPlayer();
        do {
            player.inputStrikeNumber();
            opponent.calculateStrike(player.getStrikeNumber());
            System.out.println(opponent.getMessage());
        } while (!isGameEnd());
    }

    private boolean isGameEnd() {
        return opponent.isLose() && exitGame();
    }

    private boolean exitGame() {
        System.out.println("게임을 새로 시작하려면 1 종료하려면 2 를 입력하세요.");

        Scanner scan = new Scanner(System.in);
        String inputData;
        do {
            inputData = scan.nextLine();
        } while (!isCorrectCommand(inputData));

        executeCommand(inputData);

        return UserCommandEnum.COMMAND_END.equals(inputData);
    }

    private boolean isCorrectCommand(String inputData) {
        if (!UserCommandEnum.contains(inputData)) {
            System.out.println("1 또는 2 를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private void executeCommand(String inputData) {
        if(UserCommandEnum.COMMAND_RESTART.equals(inputData)) {
            initPlayer();
        }
    }
}
