package baseball.common;

import baseball.util.BaseballUtil;
import baseball.view.BaseballClient;

public class BaseballGame {

    BaseballClient client = new BaseballClient();
    String randomStr;
    String input;

    int strike=0;
    int ball=0;
    int flag = GAME_RESTART;

    public void startGame(){
        while(this.flag==GAME_RESTART){
            this.randomStr = BaseballUtil.getValidRandomNumber();
            guess();
            this.flag = client.displayGameOption();
            initHint();
        }
        client.displayFinishMessage();
    }

    public void guess(){
        while(!isFinish()) {
            initHint();
            this.input = client.getUserinput();
            client.displayGameResult(compareInput(this.input, this.randomStr));
        }
    }

    public void initHint(){
        this.ball = 0;
        this.strike = 0;
    }

    public String compareInput(String guess, String answer){
        for(int i=0; i<MAX_NUM; i++){
//            System.out.println(this.strike+STRIKE+" " + this.ball+BALL);
            this.strike += isStrike(guess.charAt(i), answer.charAt(i));
            this.ball += isBall(guess.charAt(i), answer.charAt(i));
        }
        return returnResultMsg(ball,strike);
    }

    public boolean isFinish(){
        if(this.strike==MAX_NUM){
            client.displayFinishMessage();
            return true;
        }
        return false;
    }

    public int isStrike(char a, char b){
        if(a==b) return 1;
        return 0;
    }

    public int isBall(char a, char b) {
        if (a != b) return 1;
        return 0;
    }

    public String returnResultMsg(int ball, int strike){
        if(strike==0) return NOTHING;
        if(ball==0) return strike+STRIKE;
        return strike+STRIKE+" "+ ball+BALL;
    }
}
