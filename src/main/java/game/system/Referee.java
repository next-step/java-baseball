package game.system;

import game.ui.UserInterface;
import game.ui.UtilUserInterface;

import java.util.Arrays;

public class Referee {

    private String key;
    private int strikeCount;
    private int ballCount;

    public Referee(int[] digits){
        this.key = Arrays.toString(digits).replaceAll("[^0-9]","");
        InitializeZeroCount();
    }

    public boolean judgeBatting(String batting){
        InitializeZeroCount();
        compareWithKey(batting);

        if(isStrikeOut()) return true;
        displayHintMessage();
        return false;
    }

    private void InitializeZeroCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    public void compareWithKey(String batting){

        String key = getKey();
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < batting.length(); i++){
            int position = i;
            char digitChar = batting.charAt(position);
            String digitString = String.valueOf(digitChar);
            if(key.contains(digitString)){
                setBallCount(++ballCount);
            }
            if(key.charAt(position) == digitChar){
                setBallCount(--ballCount);
                setStrikeCount(++strikeCount);
            }
        }
    }

    public String createHintMessage(){

        String hintMessage = "";
        int ballCount = getBallCount();
        int strikeCount = getStrikeCount();

        if(strikeCount > 0) hintMessage += strikeCount + "스트라이크";
        if(ballCount > 0) {
            if(strikeCount != 0){
                hintMessage += " ";
            }
            hintMessage += ballCount + "볼";
        }
        if(strikeCount == 0 && ballCount == 0) hintMessage = "낫싱";

        return hintMessage;
    }

    public void displayHintMessage(){
        String hintMessage = createHintMessage();
        UtilUserInterface.displayMessage(hintMessage);
    }

    public boolean askFinish(){
        boolean isLastGame = false;
        String message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        String userIntention = UtilUserInterface.getUserInput(UserInterface.ASK_FINISH, message);

        if(userIntention.equals("1")) isLastGame = false;
        if(userIntention.equals("2")) isLastGame = true;

        return isLastGame;
    }

    public boolean isStrikeOut(){
        if(strikeCount == 3) return true;
        return false;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public String getKey() {
        return key;
    }
}
