package domain;

import java.util.List;

public class BaseballGame {
    private List<Number> gameNumbers;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.gameNumbers = numberGenerator.generate();
    }

}
