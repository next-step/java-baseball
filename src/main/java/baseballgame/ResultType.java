package baseballgame;

public enum ResultType {
    THREE_STRIKE(3, 0, "3 스트라이크"),
    ONE_STRIKE_ONE_BALL(1, 1, "1 스트라이크 1 볼"),
    ONE_STRIKE_TWO_BALL(1, 2, "1 스트라이크 2 볼"),
    TWO_STRIKE(2, 0, "2 스트라이크"),
    ONE_BALL(0, 1, "1 볼"),
    TWO_BALL(0, 2, "2 볼"),
    THREE_BALL(0, 3, "3 볼"),
    NOTHING(0, 0, "낫싱");

    private int strikeCount;
    private int ballCount;
    private String resultString;

    ResultType(int strikeCount, int ballCount, String resultString) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.resultString = resultString;
    }

    public static ResultType getResultTypeOfCount(int strikeCount, int ballCount) {
        ResultType resultType = NOTHING;

        ResultType[] values = ResultType.values();
        for(ResultType type : values) {
            resultType = type.checkRightResultType(strikeCount, ballCount, resultType);
        }
        return resultType;
    }

    private ResultType checkRightResultType(int strikeCount, int ballCount, ResultType resultType) {
        if(this.strikeCount == strikeCount && this.ballCount == ballCount) {
            resultType = this;
        }
        return resultType;
    }

    public String getResultString() {
        return resultString;
    }
}
