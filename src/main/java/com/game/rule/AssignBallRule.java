package com.game.rule;

import java.util.Arrays;
import java.util.List;

public class AssignBallRule {
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean gameFlag = true;

    public void infoGameResult(List<String> comNumberList, List<String> userNumberList) {
        if(!checkNumberList(comNumberList,userNumberList)){
            setInitCount();
            assignBallType(comNumberList,userNumberList);
        }
        return;
    }

    private void setInitCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void setNoCount() {
        this.strikeCount = -1;
        this.ballCount = -1;
    }

    private boolean checkNumberList(List<String> comNumberList, List<String> userNumberList) {
        if(comNumberList.size() == 0 || userNumberList.size() == 0){
            setNoCount();
            return true;
        }
        return false;
    }

    private void assignBallType(List<String> comNumberList, List<String> userNumberList) {
        String[] comArray = comNumberList.toArray(new String[3]);
        String[] userArray = userNumberList.toArray(new String[3]);
        for(int idx = 0; idx < 3 ; idx++) {
            matchStrike(comArray,userArray[idx],idx);
            matchBall(comArray,userArray[idx],idx);
        }
        matchNothing(comNumberList, userNumberList);
        matchThreeStrike(comNumberList, userNumberList);
    }

    private void matchStrike(String[] comNumberList,String number, int idx) {
        if(Arrays.asList(comNumberList).contains(number) && (comNumberList[idx].equals(number))) {
            strikeCount++;
        }
    }

    private void matchBall(String[] comNumberList,String number, int idx) {
        if(Arrays.asList(comNumberList).contains(number) && (!comNumberList[idx].equals(number))) {
            ballCount++;
        }
    }

    private void matchNothing(List<String> comNumberList, List<String> userNumberList){
        userNumberList.removeAll(comNumberList);
        if(userNumberList.size() == 3) {
            this.strikeCount = 0;
            this.ballCount = 0;
        }
    }

    private void matchThreeStrike(List<String> comNumberList, List<String> userNumberList) {
        if(Arrays.equals(comNumberList.toArray(),userNumberList.toArray())) {
            this.strikeCount = 3;
            this.ballCount = 0;
        }
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public boolean getGameFlag() {
        if((strikeCount == 3 && ballCount ==0)) {
            gameFlag = false;
        }
        return this.gameFlag;
    }


}
