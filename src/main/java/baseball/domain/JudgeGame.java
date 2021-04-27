package baseball.domain;

import java.util.List;
import java.util.Scanner;

public class JudgeGame {

    private int STRIKE_CNT;
    private int BALL_CNT;

    public void compareNum(Ball comNumber, Ball userNumber){
        STRIKE_CNT = 0;
        BALL_CNT = 0;
        System.out.println(comNumber.getBall());
        for(int i=0;i<3;i++){
            getStrike(comNumber.getBall(), userNumber.getBall(), i);
            getBall(comNumber.getBall(), userNumber.getBall(), i);
        }

        BALL_CNT -= STRIKE_CNT;
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
        if(STRIKE_CNT==0 && BALL_CNT ==0){
            System.out.println("낫싱");
        }else {
            System.out.println(STRIKE_CNT + "스트라이크 , " + BALL_CNT + "볼");
        }
    }

    public boolean chkFinishGame(){
        boolean continueFlag = true;

        if(STRIKE_CNT == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            continueFlag = false;
        }

        return continueFlag;
    }


    public static boolean chkContinueGame(){
        boolean rtnFlag = false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();

        if("1".equals(inputNum)){
            rtnFlag = true;
        }

        return rtnFlag;
    }

}
