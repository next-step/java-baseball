package khj.baseball.flow;

import khj.baseball.BaseBallGame;
import khj.baseball.Game;

import java.util.Scanner;

public class Flow {
    private final Game game;

    private final String START_GAME = "1";
    private final String STOP_GAME = "2";
    private int playCount = 0;

    public Flow(Game game) {
        this.game = game;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String selection = "1";

        do {
            ++playCount;
            startGame(selection);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selection = scanner.nextLine();
        } while (!isStopGame(selection));
    }

    private void startGame(String selection) {
        if (isStartGame(selection)) {
            game.play();
        }
    }

    private boolean isStopGame(String selection) {
        return STOP_GAME.equals(selection);
    }

    private boolean isStartGame(String selection) {
        return START_GAME.equals(selection);
    }

    public int getPlayCount() {
        return playCount;
    }
}
