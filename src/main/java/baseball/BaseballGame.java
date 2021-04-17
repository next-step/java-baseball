package baseball;

import com.sun.org.apache.xpath.internal.operations.Bool;
import view.Input;
import view.Output;

import java.util.List;

public class BaseballGame {
    public void gameStart() {
        Boolean success;
        String inputNum;
        List<Integer> randomNumberList = makeRandomNumberList();

        while(true){
            inputNum = inputNum();
            if(!checkInputNumValid(inputNum)){
                continue;
            }
            success = checkSuccess(randomNumberList, inputNum);
            if(!success){
                continue;
            }
            if(!checkRestart()){
                break;
            } else{
                randomNumberList = makeRandomNumberList();
            }
        }
    }
    private List<Integer> makeRandomNumberList() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.makeRandomNumberList();
    }

    private String inputNum() {
        Input input = new Input();
        return input.startGame();
    }

    private Boolean checkInputNumValid(String inputNum) {
        CheckInputNumValidation checkInputNumValidation = new CheckInputNumValidation();
        return checkInputNumValidation.isValid(inputNum);
    }

    private Boolean checkSuccess(List<Integer> randomNumberList, String inputNum){
        CheckResult checkResult = new CheckResult();
        return checkResult.getResult(randomNumberList, inputNum);
    }

    private Boolean checkRestart() {
        Output output = new Output();
        int restartNum;
        while(true) {
            restartNum = output.reStart();
            if (restartNum == 1) {
                return true;
            } else if (restartNum == 2) {
                break;
            } else {
                //에러 메시자
                System.out.println("옳바른 값 입력해주세요");
            }
        }
        return false;
    }

}

