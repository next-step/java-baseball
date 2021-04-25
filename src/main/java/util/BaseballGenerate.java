package util;

import domain.baseball.Baseball;
import domain.baseball.BaseballGroup;

import java.util.*;

public class BaseballGenerate {

    public static BaseballGroup createBaseballGroup(){
        List<Baseball> baseballGroup = new ArrayList<>();
        Set<Long> baseballRandomValues = new HashSet<>();

        int minBaseballNum = Baseball.getMinValue();
        int maxBaseballNum = Baseball.getMaxValue();

        while (baseballRandomValues.size() < BaseballGroup.getRandomLength()){
            Number randomBaseballNum = new Random().nextInt((maxBaseballNum - minBaseballNum) + 1) + minBaseballNum;
            baseballRandomValues.add(randomBaseballNum.longValue());
        }

        for(Long randomBaseballNum : baseballRandomValues){
            baseballGroup.add(createBaseballValue(randomBaseballNum));
        }

        return new BaseballGroup(baseballGroup);
    }


    public static Baseball createBaseballValue(Long numberValue){
        return new Baseball(numberValue);
    }
}
