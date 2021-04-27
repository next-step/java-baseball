package util;

import domain.BaseBallNumberInfo;

import java.util.List;

public class RandomNumberUtil {

    public static void makeBaseBall(BaseBallNumberInfo baseBallNumberInfo){

        boolean numberCheck = false;

        while(numberCheck == false) {
            makeRandomNumber(baseBallNumberInfo);
            numberCheck = CheckDuplicateUtil.checkDuplicateNumber(baseBallNumberInfo.getBaseBallRandomNumberList());
        }

    }

    public static void makeRandomNumber(BaseBallNumberInfo baseBallNumberInfo) {

        baseBallNumberInfo.getBaseBallRandomNumberList().clear();
        for(int pos = 0; pos < 3; pos++) {
            baseBallNumberInfo.setBaseBallPositionNumber((int)(Math.random() * 9) + 1);
        }
    }

}
