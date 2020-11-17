package game.baseball.number.participants;

import game.baseball.number.participants.evaluators.Evaluator;
import game.baseball.number.participants.evaluators.Evaluators;
import game.baseball.number.utils.ConsoleOutputUtil;
import game.baseball.number.validator.NumbersValidator;
import game.baseball.number.validator.Validator;

public class NumbersBaseballGame {

    private final Referee referee;
    private final Pitcher pitcher;
    private final Hitter hitter;

    public NumbersBaseballGame() {
        Evaluator strikeEvaluator = Evaluators.strikeEvaluator();
        Evaluator ballEvaluator = Evaluators.ballEvaluator();
        Validator<String> validator = new NumbersValidator();
        this.referee = Referee.with(strikeEvaluator, ballEvaluator, validator);
        this.pitcher = new Pitcher();
        this.hitter = new Hitter();
    }

    public void start() {
        String numbers = pitcher.throwNumbers();
        referee.saveNumbers(numbers);
        String hittingNumbers = hitter.hit();
        while (!referee.judge(hittingNumbers)) {
            ConsoleOutputUtil.printNextLine();
            hittingNumbers = hitter.hit();
        }
    }
}
