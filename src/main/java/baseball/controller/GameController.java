package baseball.controller;

import baseball.domain.GameStatus;
import baseball.domain.MatchResult;
import baseball.domain.ThreeBall;
import baseball.domain.strategy.BallGenerateStrategy;
import baseball.domain.strategy.RandomNumberGenerateStrategy;
import baseball.domain.strategy.RandomNumberStrategy;
import baseball.domain.strategy.ThreeBallGenerateStrategy;
import baseball.exception.UserInputException;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

    private static final int QUOTIENT = 0;
    private static final int INPUT_SIZE = 3;
    private static final int DIVIDE_VALUE = 10;
    private static final String INPUT_ERROR_MESSAGE = "3자리 숫자를 입력해 주세요";
    private static final String INPUT_CONTINUE_ERROR_MESSAGE = "1 또는 2를 입력해 주세요";

    private final GameService gameService;

    public GameController(GameService service) {
        this.gameService = service;
    }

    public void start() {
        GameStatus gameStatus = GameStatus.CONTINUE;
        RandomNumberStrategy numberStrategy = new RandomNumberGenerateStrategy();
        BallGenerateStrategy ballStrategy = new ThreeBallGenerateStrategy(numberStrategy);
        ThreeBall goal = gameService.generateGoal(ballStrategy);

        while (GameStatus.CONTINUE.equals(gameStatus)) {
            gameStatus = playOneGame(goal);
            goal = gameService.generateGoal(ballStrategy);
        }
    }

    private GameStatus playOneGame(final ThreeBall goal) {
        boolean runFlag = true;

        while (runFlag) {
            String userInput = InputView.inputNumber();
            List<Integer> userNumbers = parseUserInput(userInput);
            MatchResult matchResult = gameService.compareGoal(goal, userNumbers);
            OutputView.showMatchResult(matchResult);
            runFlag = !(matchResult.isGameComplete());
        }

        return chooseContinue();
    }

    private GameStatus chooseContinue() {
        String input = InputView.inputContinue();
        int continueInput = parseToNumber(input);

        if (continueInput == 1) {
            return GameStatus.CONTINUE;
        }

        return GameStatus.END;
    }

    private List<Integer> parseUserInput(final String userInput) {
        if (userInput.length() != INPUT_SIZE) {
            throw new UserInputException(INPUT_ERROR_MESSAGE);
        }
        int userNumber = parseToNumber(userInput);
        return splitNumberOneDigit(userNumber);
    }

    private List<Integer> splitNumberOneDigit(int userInput) {
        List<Integer> result = new ArrayList<>();

        while (userInput != QUOTIENT) {
            int remainder = userInput % DIVIDE_VALUE;
            userInput = userInput / DIVIDE_VALUE;
            result.add(remainder);
        }

        Collections.reverse(result);
        return result;
    }

    private int parseToNumber(final String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new UserInputException(INPUT_CONTINUE_ERROR_MESSAGE);
        }
    }

}
