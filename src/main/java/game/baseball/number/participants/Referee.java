package game.baseball.number.participants;

import game.baseball.number.participants.evaluators.Evaluator;
import game.baseball.number.utils.ConsoleOutputUtil;
import game.baseball.number.validator.Validator;

final class Referee {

    private final Evaluator strikeEvaluator;
    private final Evaluator ballEvaluator;
    private final Validator<String> validator;

    private static final String NOTHING_TEXT = "낫싱";
    private static final int NOTHING = 0;
    private static final int ANSWER = 3;

    private String pitchedNumbers;

    private Referee(Evaluator strikeEvaluator, Evaluator ballEvaluator, Validator<String> validator) {
        this.strikeEvaluator = strikeEvaluator;
        this.ballEvaluator = ballEvaluator;
        this.validator = validator;
    }

    static Referee with(Evaluator strikeEvaluator, Evaluator ballEvaluator, Validator<String> validator) {
        return new Referee(strikeEvaluator, ballEvaluator, validator);
    }

    void saveNumbers(String pitchedNumbers) {
        validator.validate(pitchedNumbers);
        this.pitchedNumbers = pitchedNumbers;
    }

    boolean judge(String hitNumbers) {
        validator.validate(hitNumbers);
        int strikes = strikeEvaluator.evaluate(pitchedNumbers, hitNumbers);
        int balls = ballEvaluator.evaluate(pitchedNumbers, hitNumbers);
        if (strikes == NOTHING && balls == NOTHING) {
            ConsoleOutputUtil.print(NOTHING_TEXT);
        }
        return strikes == ANSWER;
    }
}
