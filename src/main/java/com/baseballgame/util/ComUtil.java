package com.baseballgame.util;

import java.util.ArrayList;
import java.util.List;

public class ComUtil {

    private static final int ARR_LENGTH = 3;
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;
    private List<String> targetNumberList;

    public List<String> generateTargetNum(){
        do {
            validationNumber(getRamdomNum());
        } while(targetNumberList.size() < ARR_LENGTH);
        return targetNumberList;
    }

    public String getRamdomNum(){
        int ramdomNum = (int)(Math.random() * MAX_NUM) + MIN_NUM;
        return String.valueOf(ramdomNum);
    }

    public void validationNumber (String ramdomNum){
        if(targetNumberList == null){
            targetNumberList = new ArrayList<String>();
            targetNumberList.add(ramdomNum);
            return;
        }
        if(targetNumberList.contains(ramdomNum)){
            return;
        }
        targetNumberList.add(ramdomNum);
    }

}
