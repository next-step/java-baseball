package baseball.view;

import baseball.domain.Result;

public class BaseballResultView {
    private static final String STRIKE = " 스트라이크 ";
    private static final String BALL = " 볼 ";
    private static final String NOTHING = "낫싱";

    public static Boolean showResult(Result result) {
        String stringResult = "";
        if(!result.getStrike().toString().equals("0")) {
            stringResult += result.getStrike().toString().concat(STRIKE);
        }
        if(!result.getBall().toString().equals("0")) {
            stringResult += result.getBall().toString().concat(BALL);
        }
        if(stringResult.equals("")) {
            stringResult += NOTHING;
        }
        System.out.println(stringResult);
        if(result.getStrike().toString().equals("3")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        return false;
    }
}
