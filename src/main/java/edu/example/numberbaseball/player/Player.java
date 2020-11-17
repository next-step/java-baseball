package edu.example.numberbaseball.player;

import edu.example.numberbaseball.common.Inning;

import java.util.List;

/**
 * 야구게임을 즐기는 `Player`
 */
public class Player {
    private final Inning inning;
    private PlayerStatus status = PlayerStatus.INACTIVE;

    public Player(Inning inning) {
        activate();
        this.inning = inning;
    }

    public void activate() {
        this.status = PlayerStatus.ACTIVE;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public List<Integer> getBallNumberList() {
        return inning.getBallNumberList();
    }

    public int getBallNumber(int index) {
        return getBallNumberList().get(index);
    }
}
