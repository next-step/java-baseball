package com.bbidag.baseball;

public class Referee {
    private int strikeCount;
    private int ballCount;
    private final Computer computer;

    public Referee(Computer computer){
        this.computer = computer;
    }

    public boolean applyWinOrNot() {
        return strikeCount == 3;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount){
        this.ballCount = ballCount;
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }
}
