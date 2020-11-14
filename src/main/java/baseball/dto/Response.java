package baseball.dto;

import baseball.domain.MatchResult;

public class Response {
    private final int strikeCount;
    private final int ballCount;

    public static Response from(MatchResult matchResult) {
        return new Response(matchResult.strikeCount(), matchResult.ballCount());
    }

    public Response(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
