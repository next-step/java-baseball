package game.baseball.number.participants;

import game.baseball.number.participants.evaluators.Evaluator;
import game.baseball.number.validator.NumbersValidator;
import game.baseball.number.validator.Validator;

final class Referee {

    private final Evaluator strikeEvaluator;
    private final Evaluator ballEvaluator;
    private final Validator<String> validator;

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
        boolean isAnswer = strikeEvaluator.test(pitchedNumbers, hitNumbers);
        ballEvaluator.test(pitchedNumbers, hitNumbers);
        return isAnswer;
    }
}
