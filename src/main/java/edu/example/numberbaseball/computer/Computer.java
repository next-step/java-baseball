package edu.example.numberbaseball.computer;

import edu.example.numberbaseball.common.Inning;

/**
 * `Player`를 상대할 `Computer`
 */
public class Computer {
    private Inning inning = new Inning();

    public void reset() {
        this.inning = new Inning();
    }

    public Inning getInning() {
        return inning;
    }
}
