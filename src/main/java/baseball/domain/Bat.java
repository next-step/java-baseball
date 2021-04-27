package baseball.domain;

import java.util.List;

public class Bat {
    private BallNumbers shot;

    public Bat(BallNumbers shot) {
        this.shot = shot;
    }

    public List<BallNumber> getShots() {
        return shot.getBallNumbers();
    }
}
