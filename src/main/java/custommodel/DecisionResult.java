package custommodel;

public class DecisionResult {
    private int strikeCount;
    private int ballCount;
    private int nothingCount;

    public DecisionResult(){
        this.strikeCount = 0;
        this.ballCount = 0;
        this.nothingCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
    public int getBallCount() { return ballCount; }
    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
    public int getNothingCount() {
        return nothingCount;
    }
    public void setNothingCount(int nothingCount) {
        this.nothingCount = nothingCount;
    }
    public void addStrikeCount(){
        this.strikeCount++;
    }
    public void addBallCount(){
        this.ballCount++;
    }
    public void addNothingCount(){
        this.nothingCount++;
    }

    @Override
    public String toString() {
        if (this.nothingCount == 3) {
            return "낫싱";
        }

        return this.toStringHitDecisions();
    }

    private String toStringHitDecisions() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.getStrikeCount() != 0) {
            stringBuilder.append(this.strikeCount + " 스트라이크 ");
        }

        if (this.ballCount != 0) {
            stringBuilder.append(this.ballCount + " 볼");
        }

        return stringBuilder.toString();
    }
}
