package baseball;

import view.Output;
import java.util.ArrayList;
import java.util.List;

public class CheckResult {
    List<Integer> inputNumList;
    List<Integer> randomNumList;
    int strike;
    int ball;
    Boolean success;
    Boolean notThing;


    public Boolean getResult(List<Integer> randomNumList, String inputNum) {
        inputNumList = arrayToList(inputNum);
        this.randomNumList = randomNumList;
        initResult();
        checkResult();
        outputMessage();
        return this.success;
    }

    private void initResult() {
        this.strike = 0;
        this.ball = 0;
        this.success = false;
        this.notThing = false;
    }

    private void checkResult() {
        for(int i = 0; i < inputNumList.size(); i++){
           if(isStrike(i)){
               this.strike++;
               continue;
           }
           if(isBall(i)){
               this.ball++;
           }
        }
        isSuccess();
        isNotThing();
    }

    private Boolean isStrike(int index) {
        return inputNumList.get(index).equals(randomNumList.get(index));
    }

    private Boolean isBall(int index) {
        return inputNumList.contains(randomNumList.get(index));
    }

    private void isNotThing() {
        if(this.strike == 0 & this.ball == 0){
            this.notThing = true;
        }
    }

    private void isSuccess() {
        if(this.strike == 3){
            this.success = true;
        }
    }

    private List<Integer> arrayToList(String inputNum) {
        List<Integer> inputNumList = new ArrayList<Integer>();

        String[] inputNumArray = inputNum.split("");
        for(String num : inputNumArray){
            inputNumList.add(Integer.parseInt(num));
        }
        return inputNumList;
    }

    private void outputMessage() {
        Output output = new Output();
        if(this.success) {
            output.strikeAndBall(this.strike, this.ball);
            output.success();
        } else if(this.notThing) {
            output.notThing();
        } else {
            output.strikeAndBall(this.strike, this.ball);
        }
    }
}
