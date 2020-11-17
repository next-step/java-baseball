package game.system;

import game.ui.UserInterface;
import game.ui.UtilUserInterface;

import java.util.Arrays;

public class Referee {

    private int key;
    private int strikeCount;
    private int ballCount;

    public Referee(int[] digits){
        this.key = Integer.parseInt(Arrays.toString(digits).replaceAll("[^0-9]",""));
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean judgeBatting(int battingDigit){
        if(isStrikeOut(battingDigit)) return true;
        return false;
    }

    public boolean askFinish(){
        boolean isLastGame = false;
        String message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        int userIntention = UtilUserInterface.viewUI(UserInterface.ASK_FINISH, message);

        if(userIntention == 1) isLastGame = false;
        if(userIntention == 2) isLastGame = true;

        return isLastGame;
    }

    public boolean isStrikeOut(int battingDigit){
        if(battingDigit == key) return true;
        return false;
    }
}
