package baseball.domain;

import baseball.exception.InputException;

import java.util.List;

public class JudgeGame {

    private int STRIKE_CNT;
    private int BALL_CNT;

    public void compareNum(Ball comNumber, Ball userNumber){
        STRIKE_CNT = 0;
        BALL_CNT = 0;
        for(int i=0;i<3;i++){
            getStrike(comNumber.getBall(), userNumber.getBall(), i);
            getBall(comNumber.getBall(), userNumber.getBall(), i);
        }
        BALL_CNT -= STRIKE_CNT;

        resultMsg();
    }


    public void getStrike(List<Integer> comBall, List<Integer> userBall, int i){
        if(comBall.get(i) == userBall.get(i)){
            STRIKE_CNT++;
        }
    }


    public void getBall(List<Integer> comBall, List<Integer> userBall, int i){
        if(comBall.contains(userBall .get(i))){
            BALL_CNT++;
        }
    }


    public void resultMsg(){
        if(!isNothing()){
            String rtnMSG = "";
            if(STRIKE_CNT>0){
                rtnMSG+=STRIKE_CNT + "스트라이크 ";
            }
            if(BALL_CNT>0){
                rtnMSG+=BALL_CNT + "볼";
            }
            System.out.println(rtnMSG);
        }
    }


    public boolean isNothing(){
        if(STRIKE_CNT==0 && BALL_CNT ==0){
            System.out.println("낫싱");
            return true;
        }
        return  false;
    }

    public boolean chkFinishGame(){
        boolean continueFlag = true;
        if(STRIKE_CNT == 3){
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueFlag = false;
        }
        return continueFlag;
    }



    public static boolean chkInputNum(String inputNum){
        boolean chkFlag = false;

        if(!"1".equals(inputNum) && !"2".equals(inputNum)){
            throw new InputException("'1' 또는 '2'를 입력해주세요.");
        }

        if("1".equals(inputNum)){
            return true;
        }

        return chkFlag;
    }

}
