package com.bbidag.baseball;

public class Referee {
    private int strikeCount;
    private int ballCount;
    private final Computer computer;

    public Referee(Computer computer){
        this.computer = computer;
    }

    public void generateRandomNumberOfComputer(){
        this.computer.setNumbers(this.computer.generateRandomNumbers());
    }

    public void calculateStrikeBall(int[] inputNumbers){
        for(int computerNumIdx=0; computerNumIdx<3; computerNumIdx++){
            setStrikeBallEachNumber(computerNumIdx, inputNumbers);
        }
    }

    public void setStrikeBallEachNumber(int computerNumIdx, int[] inputNumbers){
        int computerNumber = computer.getNumbers()[computerNumIdx];
        for(int inputNumberIdx = 0; inputNumberIdx < 3; inputNumberIdx++){
            int inputNumber = inputNumbers[inputNumberIdx];
            setStrikeIfEqualBothIndexAndNumber(inputNumberIdx, inputNumber, computerNumIdx, computerNumber);
            setBallIfEqualNumberAndNotEqualIndex(inputNumberIdx, inputNumber, computerNumIdx, computerNumber);
        }
    }

    public void setStrikeIfEqualBothIndexAndNumber(int inputIdx, int inputNumber, int computerNumberIndex, int computerNumber){
        if(inputIdx == computerNumberIndex && inputNumber == computerNumber){
            setStrikeCount(getStrikeCount() + 1);
        }
    }

    public void setBallIfEqualNumberAndNotEqualIndex(int inputIdx, int inputNumber, int computerNumberIndex, int computerNumber){
        if(inputIdx != computerNumberIndex && inputNumber == computerNumber){
            setBallCount(getBallCount() + 1);
        }
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
