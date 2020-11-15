package baseballgame.domain.game;

import baseballgame.domain.error.ScoreParseException;
import baseballgame.domain.score.Score;
import baseballgame.domain.score.ScoreParser;
import baseballgame.dto.CompareResult;
import baseballgame.ui.input.Input;
import baseballgame.ui.output.Output;

import java.util.InputMismatchException;

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

        printFinishSentences();
    }

    private boolean gameProcess() {
        try {
            printDemandingSentencesThatIsInputUserScore();

            final CompareResult result = computerScore.compare(inputUserScore());

            printCompareResult(result);

            return checkScoreMatchingPass(result);
        } catch (InputMismatchException ime) {
            printExceptionWhenInvalidInputValue();
            return false;
        } catch (ScoreParseException spe) {
            printExceptionWhenParsing();
            return false;
        } catch (Exception e) {
            return false;
        }
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

    private boolean checkScoreMatchingPass(CompareResult result) {
        return result.isPass();
    }

    private void printExceptionWhenInvalidInputValue() {
        output.errorInvalidInputValue();
    }

    private void printExceptionWhenParsing() {
        output.errorWhenScoreParsing();
    }

    private void printFinishSentences() {
        output.gameFinish();
    }
}
