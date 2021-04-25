package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private Numbers gameNumbers;
    private Results results;
    private boolean isOver;
    private final NumberGenerator numberGenerator;

    private static final String NOT_GAME_START_YET_ERROR_MESSAGE = "아직 게임이 시작되지 않았습니다.";

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public boolean isOver() {
        return this.isOver;
    }

    public Results start(Numbers inputNumbers) {
        this.results = findMatchedResults(inputNumbers);
        return this.results;
    }

    public void over() {
        validateIsGameStarted();
        this.isOver = true;
    }

    public void reset() {
        validateIsGameStarted();
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
            throw new IllegalArgumentException(NOT_GAME_START_YET_ERROR_MESSAGE);
        }
    }

    private Results findMatchedResults(Numbers inputNumbers) {
        List<Result> results = new ArrayList<>();
        for (Number inputNumber : inputNumbers.getNumbers()) {
            results.add(Result.findByCondition(gameNumbers.contains(inputNumber), gameNumbers.containsExactly(inputNumber)));
        }
        return Results.of(results);
    }
}
