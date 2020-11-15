package baseballgame.domain.game;

import baseballgame.domain.score.Score;
import baseballgame.ui.input.Input;
import baseballgame.ui.output.Output;

public class BaseballGame implements Game {
    private final Score computerScore;
    private final Input input;
    private final Output output;
    private boolean gamePass;

    public BaseballGame(Input input, Output output) {
        this.computerScore = Score.getRandomScore();
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        do {
            gamePass = gameProcess();

        } while (!gamePass);
    }

    private boolean gameProcess() {
        return false;
    }

    private void printDemandingSentencesThatIsInputUserScore() {
        output.demandingUserScore();
    }
}
