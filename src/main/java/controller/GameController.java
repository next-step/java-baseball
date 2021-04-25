package controller;

import domain.BaseBallNumberInfo;
import util.RandomNumberUtil;

import java.util.Arrays;
import java.util.List;

public class GameController {

    UserController userController;
    BaseBallNumberInfo baseBallNumberInfo;

    public GameController(){
        userController = new UserController();
        baseBallNumberInfo = RandomNumberUtil.makeRandomBaseBallInfo();
    }

    public int checkStrikeCount(List<Integer> baseBallNumberList, List<Integer> userNumberList){

        int count = 0;
        for(int i = 0; i < 3; i++) {
            count += checkPositionNumber(baseBallNumberList.get(i), userNumberList.get(i));
        }
        return count;
    }

    public int checkPositionNumber(int baseBallNumber, int userNumber){

        if(baseBallNumber != userNumber){
            return 0;
        }
        return 1;
    }

    public int checkBallCount(List<Integer> baseBallNumberList, List<Integer> userNumberList){
        int count = 0;
        for(int i = 0; i < 3; i++){
            count += checkAnotherPositionNumber(baseBallNumberList.get(i), i, userNumberList);
        }
        return count;
    }

    public int checkAnotherPositionNumber(int baseBallNumber, int position, List<Integer> userNumberList){

        int count = 0;
        if(userNumberList.contains(baseBallNumber) && baseBallNumber != userNumberList.get(position)) {
            count = 1;
        }
        return count;
    }

}
