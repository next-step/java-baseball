package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    private List<BaseballNumber> opponentNumbers;
    private List<BaseballNumber> playerNumbers;
    private int strike;
    private int ball;

    public Result(List<BaseballNumber> opponentNumbers, List<BaseballNumber> playerNumbers) {
        this.opponentNumbers = opponentNumbers;
        this.playerNumbers = playerNumbers;
        calcAnswer();
    }

    public void calcAnswer(){
        for (int i=0; i<opponentNumbers.size(); i++){
            countStrike(opponentNumbers.get(i), playerNumbers.get(i));
        }
        countBall();
    }

    private void countStrike(BaseballNumber opponentNumber, BaseballNumber playerNumber){
        if(opponentNumber.equals(playerNumber)){
            this.strike = this.strike+1;
        }
    }

    private void countBall(){
        Set<BaseballNumber> toSet = new HashSet<>();
        List<BaseballNumber> toList = new ArrayList<>();
        toList.addAll(opponentNumbers);
        toList.addAll(playerNumbers);
        toSet.addAll(toList);
        this.ball = Math.abs(Math.abs(6 - toSet.size()) - this.strike);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
