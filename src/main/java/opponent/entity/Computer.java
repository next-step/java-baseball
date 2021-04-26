package opponent.entity;

import baseball.BaseballNumber;
import opponent.Opponent;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Opponent {

    @Override
    public List<BaseballNumber> generateAnswer() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while(baseballNumbers.size() != 3){
            inputBaseballNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    @Override
    public void inputBaseballNumber(List<BaseballNumber> baseballNumbers) {
        BaseballNumber baseballNumber = new BaseballNumber(createRandomNumber());
        if(!baseballNumbers.contains(baseballNumber)){
            baseballNumbers.add(baseballNumber);
        }
    }

    private int createRandomNumber(){
        return (int) (Math.random() * 9) + 1;
    }


}
