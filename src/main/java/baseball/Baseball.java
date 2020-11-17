package baseball;

import java.util.Scanner;

public class Baseball {

    private final Player player;
    private final Opponent opponent;

    public Baseball() {
        this.player = new Player();
        this.opponent = new Opponent();
    }

    public void start() {
        boolean isReGame = false;
        while (!isReGame) {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            isReGame = scanner.nextInt() == 2;
        }
    }

    private void startGame() {
        boolean isUserCorrect = false;

        opponent.selectValue();
        while (!isUserCorrect) {
            player.inputValue();
            opponent.judgeGame(player.getValue());
            opponent.printGameResult();
            isUserCorrect = opponent.isUserCorrect();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
