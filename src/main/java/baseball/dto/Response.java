package baseball.dto;

import baseball.domain.MatchResult;

public class Response {
    private final boolean finish;
    private final int strikeCount;
    private final int ballCount;

    public static Response from(MatchResult matchResult) {
        return new Response(matchResult.isFinish(), matchResult.strikeCount(), matchResult.ballCount());
    }

    public Response(final boolean finish, final int strikeCount, final int ballCount) {
        this.finish = finish;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isFinish() {
        return finish;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
