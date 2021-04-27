package baseball.domain;

import baseball.domain.score.Normal;
import baseball.domain.score.Nothing;
import baseball.domain.score.Score;
import baseball.domain.score.Win;

import java.util.List;

public class ScoreCalculator {
    private static final int ZERO = 0;
    private static final int WIN_COUNT = 3;

    private int strikeCount;
    private int ballCount;

    public ScoreCalculator() {
        this.strikeCount = ZERO;
        this.ballCount = ZERO;
    }

    public void calculateScore(Bat bat, Ball ball) {
        List<BallNumber> playerShots = bat.getShots();
        List<BallNumber> computerNumbers = ball.getBallList();

        for (int i = 0; i < playerShots.size(); i++) {
            BallNumber playerNumber = playerShots.get(i);
            BallNumber computerNumber = computerNumbers.get(i);

            getMatchCount(playerNumber, computerNumber, computerNumbers);
        }
    }

    private void getMatchCount(BallNumber shot, BallNumber generated, List<BallNumber> computerBall) {
        if (shot.equals(generated)) {
            strikeCount++;
        }
        if (!shot.equals(generated) && computerBall.contains(shot)) {
            ballCount++;
        }
    }

    public Score getScore() {
        if (strikeCount == WIN_COUNT) {
            return new Win();
        }
        if (strikeCount > ZERO || ballCount > ZERO) {
            return new Normal(strikeCount, ballCount);
        }
        return new Nothing();
    }
}
