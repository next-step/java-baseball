package edu.example.numberbaseball.player;

import edu.example.numberbaseball.common.Inning;

import java.util.List;

/**
 * 야구게임을 즐기는 `Player`
 */
public class Player {
    private PlayerStatus status = PlayerStatus.INACTIVE;
    private final Inning inning;

    public Player(Inning inning) {
        activate();
        this.inning = inning;
    }

    public void activate() {
        this.status = PlayerStatus.ACTIVE;
    }

    public Inning getInning() {
        return inning;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    private List<Integer> getBallNumberList() {
        return inning.getBallNumberList();
    }

    public int getBallNumber(int index) {
        return getBallNumberList().get(index);
    }
}
