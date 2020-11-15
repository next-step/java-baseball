package baseballgame.domain.game;

import baseballgame.domain.score.Score;
import baseballgame.domain.score.ScoreParser;
import baseballgame.dto.CompareResult;
import baseballgame.ui.input.Input;
import baseballgame.ui.output.Output;

public class BaseballGame implements Game {
    private static final ScoreParser SCORE_PARSER = ScoreParser.getInstance();
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

    private Score inputUserScore() {
        return SCORE_PARSER.parseToGameScore(input.userScore());
    }

    private void printCompareResult(CompareResult result) {
        output.gameScore(result);
    }
}
