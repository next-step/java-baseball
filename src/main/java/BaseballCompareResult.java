public class BaseballCompareResult {

    private BaseballCompareResultStatus status;
    private int ballCount;
    private int strikeCount;

    public BaseballCompareResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;

        setStatus(this.ballCount, this.strikeCount);
    }

    public BaseballCompareResultStatus getStatus() {
        return this.status;
    }

    private void setStatus(int ballCount, int strikeCount) {
        if (ballCount + strikeCount == 0) {
            this.status = BaseballCompareResultStatus.NOTHING;
            return ;
        }

        if (ballCount + strikeCount > 3) throw new IllegalArgumentException("올바른 볼, 스트라이크 카운트가 아닙니다.");

        if (ballCount > 0 || strikeCount > 0) this.status = BaseballCompareResultStatus.EXIST;
        if (strikeCount == 3) this.status = BaseballCompareResultStatus.MATCHED;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
