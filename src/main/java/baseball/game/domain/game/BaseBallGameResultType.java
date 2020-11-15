package baseball.game.domain.game;

public enum BaseBallGameResultType {

    THREE_STRIKE(3, 0, "3 스트라이크"),
    TWO_STRIKE(2, 0, "2 스트라이크"),
    ONE_STRIKE_TWO_BALL(1, 2, "1 스트라이크 2볼"),
    ONE_STRIKE_ONE_BALL(1, 1, "1 스트라이크 1볼"),
    ONE_STRIKE(1, 0, "1 스트라이크"),
    THREE_BALL(0, 3, "3볼"),
    TWO_BALL(0, 2, "2볼"),
    ONE_BALL(0, 1, "1볼"),
    NOTHING(0, 0, "낫싱");

    private Integer strikeCount;
    private Integer ballCount;
    private String printString;

    BaseBallGameResultType(Integer strikeCount, Integer ballCount, String printString) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.printString = printString;
    }

    public String getPrintString() {
        return printString;
    }

    public static BaseBallGameResultType find(BaseBallGameResult gameResult) {
        BaseBallGameResultType resultType = NOTHING;
        for(BaseBallGameResultType baseBallGameResultType: BaseBallGameResultType.values()) {
            resultType = baseBallGameResultType.getBaseBallGameResultType(gameResult, resultType);
        }

        return resultType;
    }

    private BaseBallGameResultType getBaseBallGameResultType(BaseBallGameResult gameResult, BaseBallGameResultType resultType) {
        if(this.strikeCount.equals(gameResult.getStrikeCount()) && this.ballCount.equals(gameResult.getBallCount())) {
            resultType = this;
        }
        return resultType;
    }


}
