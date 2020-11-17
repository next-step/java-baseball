package com.baseballgame.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameUtil {

    private int count = 0;
    private int strike = 0;
    private int ball = 0;

    public void setInitCount() {
        this.count = 0;
        this.strike = 0;
        this.ball = 0;
    }

    public boolean matchNumber(List<String> userNumber , List<String> comNumber) {
        if(Arrays.equals(userNumber.toArray(),comNumber.toArray())) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        return false;
    }

    public Map<String, Object> assignBallType(List<String> userNumber , List<String> comNumber) {
        Map<String, Object> ballTypeMap = new HashMap<String, Object>();
        setInitCount();
        while(count < 3){
            checkBallType(count, userNumber.get(count) ,comNumber);
            count++;
        }
        ballTypeMap.put("Strike" , strike);
        ballTypeMap.put("Ball" , ball);
        return ballTypeMap;
    }

    public void checkBallType(int count , String userNum ,List<String> comNumber ) {
        if(comNumber.indexOf(userNum) == count){
            strike ++;
        }
        if(comNumber.indexOf(userNum) != count && comNumber.indexOf(userNum) > -1){
            ball ++;
        }
    }
}
