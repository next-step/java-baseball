package game;

public class Referee {
    private final GameResult gameResult;

    public Referee() {
        this.gameResult = new GameResult();
    }

    public GameResult getGameResult(Pitcher pitcher, Hitter hitter) {
        gameResult.setStrikeCount(getStrikeCount(pitcher, hitter));
        gameResult.setBallCount(getBallCount(pitcher, hitter, gameResult.getStrikeCount()));
        return gameResult;
    }

    private int getStrikeCount(Pitcher pitcher, Hitter hitter) {
        int strikeCount = 0;
        for (int index = 0; index < hitter.getBallList().size(); index++) {
            if (hitter.getBallList().get(index).equals(pitcher.getThrowBallList().get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(Pitcher pitcher, Hitter hitter, int strikeCount) {
        return getPitcherBallContainsHitterBallCount(pitcher, hitter) - strikeCount;
    }

    private int getPitcherBallContainsHitterBallCount(Pitcher pitcher, Hitter hitter) {
        int containsCount = 0;
        for (int pitcherBall : pitcher.getThrowBallList()) {
            if (hitter.getBallList().contains(pitcherBall)) {
                containsCount++;
            }
        }
        return containsCount;
    }
}
