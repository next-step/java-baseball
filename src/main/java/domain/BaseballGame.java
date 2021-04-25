package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final Numbers gameNumbers;
    private Results results;
    private boolean isOver;

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

    private Results findMatchedResults(Numbers inputNumbers) {
        List<Result> results = new ArrayList<>();
        for (Number inputNumber : inputNumbers.getNumbers()) {
            results.add(Result.findByCondition(gameNumbers.contains(inputNumber), gameNumbers.containsExactly(inputNumber)));
        }
        return Results.of(results);
    }
}
