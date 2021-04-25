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
            makeRandomNumber(baseBallNumberInfo.getBaseBallRandomNumberList());
            numberSize = CheckDuplicateUtil.checkDuplicateNumber(baseBallNumberInfo.getBaseBallRandomNumberList());
        }

        return baseBallNumberInfo;
    }

    public static void makeRandomNumber(List<Integer> baseBallNumberList) {

        baseBallNumberList.clear();
        for(int pos = 0; pos < 3; pos++) {
            baseBallNumberList.add((int)(Math.random() * 9) + 1);
        }
    }

}
