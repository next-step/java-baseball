package game.system;

import game.ui.UtilUserInterface;

import java.util.Arrays;

public class Referee {

    private boolean lastGame;
    private int key;
    private int strikeCount;
    private int ballCount;

    public Referee(int[] digits){
        this.key = Integer.parseInt(Arrays.toString(digits).replaceAll("[^0-9]",""));;
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean judgeBatting(int battingDigit){
        if(isStrikeOut(battingDigit)) return true;
        return false;
    }

    public void askContinue(){
        String message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        int finishIntention= UtilUserInterface.viewUI(message);

        if(finishIntention == 1) this.lastGame = false;
        if(finishIntention == 2) this.lastGame = true;
        if(finishIntention != 1 && finishIntention != 2) this.lastGame = true;
    }

    public boolean isLastGame(){
        return lastGame;
    }

    public boolean isStrikeOut(int battingDigit){
        if(battingDigit == key) return true;
        return false;
    }
}
