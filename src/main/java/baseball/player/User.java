package baseball.player;

import baseball.Message;
import baseball.BaseballUtil;

public class User {

    public int[] ready(int ballCount){
        boolean validCheck = false;
        String inputBall = "";
        while(!validCheck){
            inputBall = selectBall();
            validCheck = ballValidationCheck(inputBall, ballCount);
        }
        return convertToArray(inputBall, ballCount);
    }

    public String selectBall(){
        BaseballUtil baseballUtil = new BaseballUtil();
        return baseballUtil.inputNumber(9);
    }

    public int[] convertToArray(String ball, int ballCount) {
        int[] balls = new int[ballCount];
        for(int i = 0; i < ballCount; i++){
             balls[i] = ball.charAt(i) - '0';
        }
        return balls;
    }

    public boolean ballValidationCheck(String inputBall, int ballCount){
        if (!lengthCheck(inputBall, ballCount)) {
            System.out.println(Message.INVALID.getMessage());
            return false;
        }
        int[] balls = convertToArray(inputBall, ballCount);
        for (int i = 0; i < ballCount; i++) {
            if (!duplicationCheck(balls, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean lengthCheck(String inputBall, int ballCount){
        if( inputBall.length() == ballCount){
            return true;
        }
        return false;
    }

    public boolean duplicationCheck(int[] balls, int i){
        for (int j = 0; j < i; j++) {
            if(balls[i] == balls[j]){
                System.out.println(Message.INVALID.getMessage());
                return false;
            }
        }
        return true;
    }

}
