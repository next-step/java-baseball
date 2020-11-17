package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class BallCount {

    private static final int THREE_STRIKE_COUNT = 3;
    private static final int NOTHING_COUNT = 0;

    private int strikeCount = 0;
    private int ballCount = 0;
    private Set<Integer> strikeIndex = new HashSet<>();

    public void addStrikeCount(int strikeIndexInput) {
        this.strikeCount++;
        strikeIndex.add(strikeIndexInput);
    }

    public boolean isStrikeLocation(Integer strikeIndexInput) {
        return strikeIndex.contains(strikeIndexInput);
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return strikeCount + ballCount == NOTHING_COUNT;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE_COUNT;
    }

}
