package khj.baseball.flow;

import khj.baseball.BaseBallGame;

import java.util.Scanner;

public class Flow {
    private final BaseBallGame baseBallGame;
    private final Scanner scanner = new Scanner(System.in);

    private final String START_GAME = "1";
    private final String STOP_GAME = "2";

    public Flow(BaseBallGame baseBallGame) {
        this.baseBallGame = baseBallGame;
    }

    public void start() {
        String selection = "1";

        do {
            startGame(selection);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selection = scanner.nextLine();
        } while (!isStopGame(selection));
    }

    private boolean isStopGame(String selection) {
        return STOP_GAME.equals(selection);
    }

    private void startGame(String selection) {
        if (isStartGame(selection)) {
            baseBallGame.play();
        }
    }

    private boolean isStartGame(String selection) {
        return START_GAME.equals(selection);
    }
}
