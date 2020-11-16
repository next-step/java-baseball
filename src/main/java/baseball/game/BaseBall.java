package baseball.game;

import baseball.result.BaseBallResult;
import baseball.result.BaseBallRulResult;

public class BaseBall {

    private final String result;

    public BaseBall(String result) {
        this.result = result;
    }
    
    public BaseBallResult play(String inputValue) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == inputValue.charAt(i)){
                strike++;
            } else if (result.equals(inputValue.charAt(i)+"")) {
                ball++;
            }
        }

        return BaseBallRulResult.rulResult(strike, ball);
    }
}
