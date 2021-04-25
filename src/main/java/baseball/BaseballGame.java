package baseball;

import java.util.List;

import customtypes.Decision;
import customtypes.GameResult;
import customtypes.UserInputValidation;
import custommodel.DecisionResult;

public class BaseballGame {
    private BaseballReferee baseballReferee;
    private RandomGenerator randomGenerator;

    private InputValidator inputValidator;
    private DecisionPrinter decisionPrinter;
    private DecisionCounter decisionCounter;

    private String computerInput;

    public BaseballGame(
            BaseballReferee baseballReferee,
            RandomGenerator randomGenerator) {
        this.baseballReferee = baseballReferee;
        this.randomGenerator = randomGenerator;

        this.inputValidator = new InputValidator();
        this.decisionPrinter = new DecisionPrinter();
        this.decisionCounter = new DecisionCounter();

        // [ 210425 praivesi ] Baseball game must have 3 trial, so pass digitCount parameter as 3
        this.computerInput = this.randomGenerator.getRandomDigits(3);
    }

    public GameResult play(String playerInput) {
        UserInputValidation valResult = this.inputValidator.validate(playerInput);

        if (valResult != UserInputValidation.VALID) { return GameResult.INVALID_INPUT; }

        DecisionResult decisionResult = this.pitching(playerInput);

        this.decisionPrinter.printDecisionResult(decisionResult);

        return this.judgeGameResult(decisionResult);
    }

    private DecisionResult pitching(String playerInput) {
        List<Decision> decisions = this.baseballReferee.decide(playerInput.toCharArray(), this.computerInput);

        DecisionResult decisionResult = this.decisionCounter.countDecisions(decisions);

        return decisionResult;
    }

    private GameResult judgeGameResult(DecisionResult decisionResult) {
        return decisionResult.getStrikeCount() == 3 ? GameResult.WIN : GameResult.LOSE;
    }
}