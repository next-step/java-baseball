package baseball;

import static enumType.SystemNumberType.DIGIT;
import static enumType.GameNoticeType.GAME_WIN_MESSAGE;
import static enumType.UmpireType.*;

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
        
        if(this.getStrikeCnt() == DIGIT.getNumber()) {
            isWin = true;
            System.out.println(GAME_WIN_MESSAGE.getMessage()); 
        }
        
        return isWin;
    }
}
