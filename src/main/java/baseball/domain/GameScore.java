package baseball.domain;

import baseball.configuration.BaseballConfiguration;

public class GameScore {

    private int strike;
    private int ball;

    public GameScore(){
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameClear(){
        if (this.strike == BaseballConfiguration.REQUIRED_COUNT) {
            return true;
        }
        return false;
    }

    public void checkGameScore(String[] randomNumbers, String inputNumber){

        this.strike = 0;
        this.ball = 0;

        String[] inputNumbers = inputNumber.split("");

        for (int i = 0; i < randomNumbers.length ; i++){
            String num = randomNumbers[i];
            for (int j = 0; j < inputNumbers.length; j++){
                if (num.equals(inputNumbers[j]) && i == j) {
                    this.strike++;
                    break;
                }
                if (num.equals(inputNumbers[j]) && i != j) {
                    this.ball++;
                    break;
                }
            }
        }
    }

    public boolean isExistStrikeCount(){
        if(this.strike != 0){
            return true;
        }
        return false;
    }

    public boolean isExistBallCount(){
        if(this.ball != 0){
            return true;
        }
        return false;
    }



}