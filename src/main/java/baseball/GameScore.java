package baseball;

import static enumType.SystemNumberType.DIGIT;

public class GameScore {
    
    private int strikeCnt  = 0;
    private int ballCnt    = 0;
    
    public void strike() {
        this.strikeCnt++;
    }
    
    public void ball() {
        this.ballCnt++;
    }
    
    public int getStrikeCnt() {
        return strikeCnt;
    }
    
    public int getBallCnt() {
        return ballCnt;
    }
    
    public boolean gameResult() {
        boolean isWin = false;
        if(this.strikeCnt == DIGIT.getNumber()) {
            isWin = true;
        }
        return isWin;
    }
}
