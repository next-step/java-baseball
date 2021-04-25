public class EvaluationResult {
    private int balls;
    private int strikes;
    private boolean isSuccess;

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void success(){
        this.isSuccess = true;
        this.strikes = ConfigConstants.BASEBALL_NUMBER_SIZE;
        this.balls = 0;
    }

    public void increaseBall() {
        this.balls++;
    }

    public void increaseStrike() {
        this.strikes++;
    }
}
