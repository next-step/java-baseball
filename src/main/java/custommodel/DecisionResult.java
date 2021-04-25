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

    public int getBallCount() {
        return ballCount;
    }

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
}
