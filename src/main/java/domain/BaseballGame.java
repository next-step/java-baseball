package domain;

import java.util.List;

public class BaseballGame {
    private final Numbers gameNumbers;
    private List<Result> results;
    private boolean isOver;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.gameNumbers = numberGenerator.generate();
    }

    public boolean isOver() {
        return this.isOver;
    }
}
