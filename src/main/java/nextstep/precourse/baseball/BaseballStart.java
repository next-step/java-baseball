package nextstep.precourse.baseball;

public class BaseballStart {

    public static void main(String[] args) {
        int strike = 0;

        BaseballNewNumber baseballNewNumber = new BaseballNewNumber();

        while(strike < 3) {
            strike = baseballNewNumber.strikeResult();
        }
    }

}
