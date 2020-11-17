package baseballgame.domain;

public class Result {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void resetCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isClear(){
        return strikeCount == 3;
    }

    public void addStrikeCount(){
        strikeCount++;
    }

    public void addBallCount(){
        ballCount++;
    }

    /*
    중복 카운팅된 볼카운트를 빼줌.
     */
    public void getActualBallCount(){
        ballCount -= strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
