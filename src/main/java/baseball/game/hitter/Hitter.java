package baseball.game.hitter;

import baseball.game.gameball.GameBall;

/**
 * 타자(컴퓨터)
 * 임의로 생성된 번호를 가지고 있다
 */
public class Hitter {

    private final GameBall gameBall;

    public Hitter(GameBall gameBall) {
        this.gameBall = gameBall;
    }

    public String swing() {
        return gameBall.toString();
    }
}
