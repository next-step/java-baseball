package nextstep.precourse.baseball;

public class BaseballStart {

    public static void main(String[] args) {
        int strike = 0;

        BaseballNewNumber baseballNewNumber = new BaseballNewNumber();
        BaseballStrikeCheck baseballStrikeCheck = new BaseballStrikeCheck();

        while(baseballStrikeCheck.baseballStrikeLoopCheck(strike)) {
            strike = baseballNewNumber.strikeResult();
        }
    }

}
