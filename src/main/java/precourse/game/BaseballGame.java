package precourse.game;

import precourse.baseball.Baseballs;
import precourse.player.Computer;
import precourse.player.User;

public class BaseballGame {

    private boolean gameInProgress = true;

    public UserChoice play(Computer computer, User user) {
        Baseballs computerBaseballs = computer.pickRandomBaseballs();

        while (gameInProgress) {
            BaseballNumberString baseballNumberString = computer.receiveAnswer(user);
            Baseballs userBaseballs = computer.pickBaseballs(baseballNumberString);
            BaseballGameResult result = computer.getBaseballGameResult(computerBaseballs, userBaseballs);
            determineGameProgress(result);
        }

        return computer.receiveChoice(user);
    }

    private void determineGameProgress(BaseballGameResult baseballGameResult) {
        ConsoleUI.showMessage(baseballGameResult.getResult());
        gameInProgress = baseballGameResult.isWrongAnswer();
    }

}
