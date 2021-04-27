package baseball.domain;

import java.util.List;

/**
 * 사용자가 입력한 공을 치게되는 숫자.
 */
public class Bat {
    private BallNumbers shot;

    public Bat(BallNumbers shot) {
        this.shot = shot;
    }

    public List<BallNumber> getShots() {
        return shot.getBallNumbers();
    }
}
