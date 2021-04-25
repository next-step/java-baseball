package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private GameNumbers gameNumbers;
    private Results results;
    private boolean isOver;
    private final NumberGenerator numberGenerator;

    private static final String NEW_GAME_COMMAND = "1";
    private static final String GAME_OVER_COMMAND = "2";

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public boolean isOver() {
        return this.isOver;
    }

    public Results start(List<Number> inputNumbers) {
        this.results = findMatchedResults(inputNumbers);
        return this.results;
    }

    public void executeCommand(String command) {
        validateIsGameStarted();
        if (command.equals(NEW_GAME_COMMAND)) {
            this.reset();
        }

        if (command.equals(GAME_OVER_COMMAND)) {
            this.over();
        }
    }

    private void over() {
        this.isOver = true;
    }

    private void reset() {
        this.gameNumbers = this.numberGenerator.generate();
        this.isOver = false;
        this.results = null;
    }

    public boolean isClear() {
        validateIsGameStarted();
        return this.results.isAllStrike();
    }

    private void validateIsGameStarted() {
        if (this.results == null) {
            throw new BaseBallGameFailureException(ErrorCode.NOT_GAME_START_YET_ERROR_MESSAGE);
        }
    }

    private Results findMatchedResults(List<Number> inputNumbers) {
        List<Result> results = new ArrayList<>();
        for (Number inputNumber : inputNumbers) {
            results.add(Result.findByCondition(gameNumbers.contains(inputNumber), gameNumbers.containsExactly(inputNumber)));
        }
        return Results.of(results);
    }
}
