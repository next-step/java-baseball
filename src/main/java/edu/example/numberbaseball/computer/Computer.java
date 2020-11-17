package edu.example.numberbaseball.computer;

import edu.example.numberbaseball.common.Inning;

import java.util.List;

/**
 * `Player`를 상대할 `Computer`
 */
public class Computer {
    private Inning inning = new Inning();

    public void reset() {
        this.inning = new Inning();
    }

    public List<Integer> getBallNumberList() {
        return inning.getBallNumberList();
    }

    public int getBallNumber(int index) {
        return getBallNumberList().get(index);
    }

    public int getNumberOfBalls() {
        return Inning.getNumberOfBalls();
    }
}
