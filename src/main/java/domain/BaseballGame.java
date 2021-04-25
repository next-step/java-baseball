package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final Numbers gameNumbers;
    private Results results;
    private boolean isOver;

    private static final String NOT_GAME_START_YET_ERROR_MESSAGE = "아직 게임이 시작되지 않았습니다.";

    public BaseballGame(NumberGenerator numberGenerator) {
        this.gameNumbers = numberGenerator.generate();
    }

    public boolean isOver() {
        return this.isOver;
    }

    public Results start(Numbers inputNumbers) {
        this.results = findMatchedResults(inputNumbers);
        return this.results;
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
