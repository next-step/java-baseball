package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    int STRIKE = 0;
    int BALL = 0;
    List<Integer> COMPUTER_NUMBER;

    public Baseball(){

    }

    /*
        타석 시작.
     */
    public void doStart(){
        setPitcher(); // 카운트 셋팅.
        while (playBall()){
            STRIKE = 0;
            BALL = 0;
        }
    }

    /*
        투수 피칭.
     */
    public void setPitcher(){
        COMPUTER_NUMBER = new ArrayList<>();
        int MAX_SIZE = 3;
        while (COMPUTER_NUMBER.size() < MAX_SIZE) {
            BaseballUtil.setRandomNumber(COMPUTER_NUMBER);
        }
    }

    /*
        타자 배팅.
     */
    private boolean playBall(){
        // 숫자 입력.
        BaseballUtil.outMessage(BaseballConst.GAME_REQ_MESSAGE);
        String input = BaseballUtil.getScannerStr();
        // input 밸리데이션.
        if(BaseballValidation.validInputStr(input)){
            ballCount(input);
            return resultGame();
        }
        return playBall();
    }

    /*
        심판 볼 카운트
     */
    private void ballCount(String ball){
        // 스트라이크 카운트
        countStrike(ball);
        // 볼 카운트
        countBall(ball);
    }

    /*
        심판 현재 스코어 호령
     */
    private void callScore(){
        StringBuffer answer = new StringBuffer();
        answer = appendStrikeStr(answer);
        answer = appendBallStr(answer);
        answer = appendFourBallStr(answer);
        BaseballUtil.outMessageN(String.valueOf(answer));
    }

    /*
        결과에 따른 사인.
     */
    private boolean resultGame(){
        if(STRIKE == 3){
            BaseballUtil.outMessageN(BaseballConst.GAME_END_MESSAGE);
            return false;
        }
        callScore();

        return true;
    }

    /*
        볼 카운팅 기능.
     */
    private void getBall(int idx, int coms, String cust){
        for(int j = 0 ; j < cust.length(); j++){
            int custNum = Integer.parseInt(String.valueOf(cust.charAt(j)));
            BALL += BaseballUtil.getNotEqualIdxTwoParams(idx, j, coms, custNum);
        }
    }

    /*
        스트라이크 카운트
     */
    private void countStrike(String custNums){
        for(int i = 0 ; i < COMPUTER_NUMBER.size(); i++){
            String tmp = String.valueOf(custNums.charAt(i));
            STRIKE += BaseballUtil.getEqual(COMPUTER_NUMBER.get(i), Integer.parseInt(tmp));
        }
    }

    /*
        볼 카운트
     */
    private void countBall(String custNums){
        for(int i = 0 ; i < COMPUTER_NUMBER.size(); i++){
            getBall(i, COMPUTER_NUMBER.get(i), custNums);
        }
    }

    /*
        결과값 스트라이크 셋팅
     */
    private StringBuffer appendStrikeStr(StringBuffer answer){
        if(STRIKE > 0 ){
            answer.append(STRIKE + "스트라이크 ");
        }
        return answer;
    }

    /*
        결과값 볼 셋팅
     */
    private StringBuffer appendBallStr(StringBuffer answer){
        if(BALL > 0 ){
            answer.append(BALL + "볼");
        }
        return answer;
    }

    /*
        결과값 포볼 셋팅
     */
    private StringBuffer appendFourBallStr(StringBuffer answer){
        if(STRIKE == 0 && BALL == 0){
            answer.append("포볼");
        }
        return answer;
    }

}
