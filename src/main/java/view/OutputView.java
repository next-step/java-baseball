package view;

import domain.BaseballResult;
import utils.UtilMeassage;

public class OutputView {

    public static Boolean showResult(BaseballResult result) {
        String stringResult = "";
        if(!result.getStrike().toString().equals("0")) {
            stringResult += result.getStrike().toString().concat(UtilMeassage.STRIKE);
        }
        if(!result.getBall().toString().equals("0")) {
            stringResult += result.getBall().toString().concat(UtilMeassage.BALL);
        }
        if(stringResult.equals("")) {
            stringResult += UtilMeassage.NOTHING;
        }
        System.out.println(stringResult);
        if(result.getStrike().toString().equals("3")) {
            System.out.println(UtilMeassage.CORRECT_ANSWER_AND_EXIT_MESSAGE);
            return true;
        }
        return false;
    }
}
