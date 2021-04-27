package baseballgame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hint {

    private static final int MATCHED_SCORE = 1;
    private static final int UNMATCHED_SCORE = 0;
    private static final int NO_COUNT = 0;
    private static final int FULL_COUNT = 3;

    private static final String NO_MESSAGE = "";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE_FORMAT = "%d 스트라이크 ";
    private static final String BALL_MESSAGE_FORMAT = "%d 볼";

    private final Map<MatchResult, Integer> matchResultCounts;

    private Hint(Map<MatchResult, Integer> matchResultCounts) {
        this.matchResultCounts = matchResultCounts;
    }

    public static Hint create(List<MatchResult> matchResultList) {
        int strikeCount = 0;
        int ballCount = 0;
        for (MatchResult matchResult : matchResultList) {
            strikeCount += matchResult.isStrike() ? MATCHED_SCORE : UNMATCHED_SCORE;
            ballCount += matchResult.isBall() ? MATCHED_SCORE : UNMATCHED_SCORE;
        }
        return new Hint(createMatchResultCounts(strikeCount, ballCount));
    }

    private static Map<MatchResult, Integer> createMatchResultCounts(int strikeCount, int ballCount) {
        final Map<MatchResult, Integer> matchResultCounts = new HashMap<>();
        matchResultCounts.put(MatchResult.STRIKE, strikeCount);
        matchResultCounts.put(MatchResult.BALL, ballCount);
        return matchResultCounts;
    }

    public String getMessage() {
        if (!isNothing()) {
            final String strikeMessage = noStrike() ? NO_MESSAGE : String.format(STRIKE_MESSAGE_FORMAT, matchResultCounts.get(MatchResult.STRIKE));
            final String ballMessage = noBall() ? NO_MESSAGE : String.format(BALL_MESSAGE_FORMAT, matchResultCounts.get(MatchResult.BALL));
            return strikeMessage + ballMessage;
        }
        return NOTHING_MESSAGE;
    }

    private boolean isNothing() {
        return noStrike() && noBall();
    }

    private boolean noBall() {
        return matchResultCounts.get(MatchResult.BALL) == NO_COUNT;
    }

    private boolean noStrike() {
        return matchResultCounts.get(MatchResult.STRIKE) == NO_COUNT;
    }

    public boolean isThreeStrike() {
        return matchResultCounts.get(MatchResult.STRIKE) == FULL_COUNT;
    }
}
