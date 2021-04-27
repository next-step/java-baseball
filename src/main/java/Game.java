import exception.BaseballException;
import player.BaseballHitter;
import player.BaseballPitcher;
import player.BaseballReferee;

import java.util.Scanner;

public class Game {

    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private boolean isRunning = true;

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
        while (!referee.isStrikeout()) {
            pitcher.throwingBall();
            referee.changePitcherNumbers(pitcher.getNumbers());
        }
    }

    private void restartOrFinish() {
        System.out.println(RESTART_MESSAGE);
        int number = scanner.nextInt();

        if (isFinishNumber(number)) {
            return;
        }
        if (number != 1) {
            throw new BaseballException.RestartNumberInputOutOfRangeException();
        }
    }

    private boolean isFinishNumber(Integer number) {
        if (number == 2) {
            isRunning = false;
        }
        return !isRunning;
    }
}
