package baseballgame.domain.parser;

import baseballgame.domain.error.ScoreParseException;
import baseballgame.domain.score.Score;

import java.util.InputMismatchException;

public class ScoreParser {
    private static final String ONLY_NUMBER_EXPRESSION = "^[0-9]+$";
    private static final ScoreParser PARSER = new ScoreParser();

    private ScoreParser() {
    }

    public static ScoreParser getInstance() {
        return PARSER;
    }

    public Score parseToGameScore(String input) {
        input = input.trim();

        try {
            validateInputValueSize(input);

            return parseToScore(from(input));

        } catch (InputMismatchException ime) {
            throw new InputMismatchException();
        } catch (Exception e) {
            throw new ScoreParseException();
        }
    }

    private void validateInputValueSize(final String input) {
        final int inputSize = input.length();
        final int SCORE_LIMIT = 3;

        if (inputSize != SCORE_LIMIT) {
            throw new InputMismatchException();
        }
    }

    private int from(final String input) {
        if (input.matches(ONLY_NUMBER_EXPRESSION)) {
            return Integer.parseInt(input);
        }

        throw new InputMismatchException();
    }

    private Score parseToScore(final int value) {
        try {
            final int hundredsDigit = (value / 100);
            final int tensDigit = ((value / 10) % 10);
            final int onesDigit = (value % 10);

            return Score.getGivenValueScore(hundredsDigit, tensDigit, onesDigit);
        } catch (Exception e) {
            throw new ScoreParseException();
        }
    }
}
