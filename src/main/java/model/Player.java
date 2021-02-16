package model;

import java.util.ArrayList;

public class Player {
    private final BaseBallNumbers baseBallNumbers;

    private Player(BaseBallNumbers baseBallNumbers) {
        this.baseBallNumbers = baseBallNumbers;
    }

    public Player of(BaseBallNumbers baseBallNumbers) {
        return new Player(baseBallNumbers);
    }
    public static Player of() {
        return new Player(BaseBallNumbers.of(new ArrayList<>()));
    }
}
