package edu.example.numberbaseball.player;

import edu.example.numberbaseball.common.Inning;

/**
 * 야구게임을 즐기는 `Player`
 */
public class Player {
    private final Inning inning;

    public Player(Inning inning) {
        this.inning = inning;
    }

    public Inning getInning() {
        return inning;
    }
}
