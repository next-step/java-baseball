public class EvaluationResult {
    private int balls;
    private int strikes;
    private Boolean isSuccess;

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public void success(){
        this.isSuccess = true;
        this.strikes = 3;
        this.balls = 0;
    }

    public void increaseBall() {
        this.balls++;
    }

    public void increaseStrike() {
        this.strikes++;
    }
}
