package com.nextstep.ppyong.service;

import com.nextstep.ppyong.validator.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CheckMatchNumberService {
    enum ResultType {
        STRIKE("스트라이크"),
        BALL("볼"),
        NONE("")
        ;

        private String name;

        ResultType(String name){
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    private String botRandomNumber;

    public CheckMatchNumberService(String botRandomNumber) {
        this.botRandomNumber = botRandomNumber;
    }

    public boolean valid(String input) {
        Map<ResultType, Integer> resultMap = new HashMap<>();
        resultMap.put(ResultType.STRIKE, 0);
        resultMap.put(ResultType.BALL, 0);

        for(int i = 0; i < input.length(); i++) {
            recordBallOrStrike(resultMap, input.charAt(i), i);
        }
        if(resultMap.get(ResultType.STRIKE) != input.length()) {
            throw new RuntimeException(getMatchResult(resultMap));
        }
        return true;
    }

    private void recordBallOrStrike(Map<ResultType, Integer> resultMap, char currentChar, int position) {
        int idx = botRandomNumber.indexOf(currentChar);
        ResultType resultType = ResultType.NONE;
        if(idx == position) {
            resultType = ResultType.STRIKE;
        }
        if(idx != position && idx != -1) {
            resultType = ResultType.BALL;
        }
        if(resultType != ResultType.NONE) {
            int typeCnt = resultMap.get(resultType);
            resultMap.put(resultType, ++typeCnt);
        }
    }

    private String getMatchResult(Map<ResultType, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (Entry<ResultType, Integer> resultTypeEntry : resultMap.entrySet()) {
            sb.append(String.format("%d %s ", resultTypeEntry.getValue(), resultTypeEntry.getKey().getName()));
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
