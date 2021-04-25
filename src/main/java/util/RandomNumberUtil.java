package util;

import domain.BaseBallNumberInfo;

import java.util.List;

public class RandomNumberUtil {

    public static BaseBallNumberInfo makeRandomBaseBallInfo(){

        BaseBallNumberInfo baseBallNumberInfo = new BaseBallNumberInfo();

        makeBaseBall(baseBallNumberInfo);

        return baseBallNumberInfo;
    }

    public static BaseBallNumberInfo makeBaseBall(BaseBallNumberInfo baseBallNumberInfo){

        int numberSize = 0;

        while(numberSize < 3) {
            makeRandomNumber(baseBallNumberInfo);
            numberSize = CheckDuplicateUtil.checkDuplicateNumber(baseBallNumberInfo.getBaseBallRandomNumberList());
        }

        return baseBallNumberInfo;
    }

    public static void makeRandomNumber(BaseBallNumberInfo baseBallNumberInfo) {

        baseBallNumberInfo.getBaseBallRandomNumberList().clear();
        for(int pos = 0; pos < 3; pos++) {
            baseBallNumberInfo.setBaseBallPositionNumber((int)(Math.random() * 9) + 1);
        }
    }

}
