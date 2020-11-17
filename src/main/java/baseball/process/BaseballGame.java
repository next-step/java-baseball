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

    /**
     * 게임 실행
     *  - 게임이 종료될 때까지 User의 입력을 받아 게임을 진행
     */
    public void executeGame() {
        initPlayer();
        do {
            player.inputStrikeNumber();
            opponent.calculateStrike(player.getStrikeNumber());
            System.out.println(opponent.getMessage());
        } while (!isGameEnd());
    }

    /**
     * 게임 종료여부 판별
     *  - Opponent가 게임에서 짐
     *  - User가 게임종료 커맨드를 입력
     * @return 상기 두 조건을 만족해야 true return
     */
    private boolean isGameEnd() {
        return opponent.isLose() && exitGame();
    }

    /**
     * 게임 나가기
     *  - User가 게임종료 커맨드를 입력하는 경우 true return
     */
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

    /**
     * User Command 검증
     */
    private boolean isCorrectCommand(String inputData) {
        if (!UserCommandEnum.contains(inputData)) {
            System.out.println("1 또는 2 를 입력해 주세요.");
            return false;
        }
        return true;
    }

    /**
     * User 커맨드 입력에 따른 로직 실행
     */
    private void executeCommand(String inputData) {
        if(UserCommandEnum.COMMAND_RESTART.equals(inputData)) {
            opponent.resetStrikeNumber();
        }
    }
}
