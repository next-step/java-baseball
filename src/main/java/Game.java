import exception.BaseballException;
import player.BaseballHitter;
import player.BaseballPitcher;
import player.BaseballReferee;

import java.util.Scanner;

public class Game {

    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_NUMBER_INPUT_ERROR_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private boolean isRunning;

    public Game() {
        isRunning = true;
    }

    public void play() {
        while (isRunning) {
            BaseballHitter hitter = new BaseballHitter();
            BaseballPitcher pitcher = new BaseballPitcher();
            playRound(pitcher, hitter);
            restartOrFinish();
        }
    }

    private void playRound(BaseballPitcher pitcher, BaseballHitter hitter) {
        BaseballReferee referee = new BaseballReferee(hitter.getNumbers(), pitcher.getNumbers());
        while (!referee.strikeout()) {
            pitcher.throwingBall();
            referee.changePitcherNumbers(pitcher.getNumbers());
        }
    }

    private void restartOrFinish() {
        System.out.println(RESTART_MESSAGE);
        int number = scanner.nextInt();

        if (number == 2) {
            isRunning = false;
            return;
        }
        if (number != 1) {
            System.out.println(RESTART_NUMBER_INPUT_ERROR_MESSAGE);
            throw new BaseballException.RestartNumberInputOutOfRangeException();
        }
    }
}
