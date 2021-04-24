package com.nextstep.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClientInputValidator {
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

    private int maxNumberSize;
    private String botRandomNumber;

    public ClientInputValidator(String botRandomNumber) {
        this.maxNumberSize = botRandomNumber.length();
        this.botRandomNumber = botRandomNumber;
    }

    public boolean checkValidNumber(String input) {
        if(!checkOnlyNumber(input) || !checkNumberLength(input)) {
            System.out.println("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
            return false;
        }
        if(checkDuplicatedNumber(input)) {
            System.out.println("세자리의 중복되지 않는 정수를 입력해주세요.");
            return false;
        }
        if(!checkMatchNumber(input)) {
            return false;
        }
        return true;
    }

    private boolean checkMatchNumber(String input) {
        Map<ResultType, Integer> resultMap = new HashMap<>();
        resultMap.put(ResultType.STRIKE, 0);
        resultMap.put(ResultType.BALL, 0);
        resultMap.put(ResultType.NONE, 0);

        for(int i = 0; i < input.length(); i++) {
            recordBallOrStrike(resultMap, input.charAt(i), i);
        }
        if(resultMap.get(ResultType.STRIKE) != input.length()) {
            printMatchResult(resultMap);
            return false;
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

    private void printMatchResult(Map<ResultType, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (Entry<ResultType, Integer> resultTypeEntry : resultMap.entrySet()) {
            sb.append(String.format("%d %s ", resultTypeEntry.getValue(), resultTypeEntry.getKey().getName()));
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private boolean checkDuplicatedNumber(String input) {
        Set<Character> checkSet = new HashSet<>();
        int idx = 0;
        int cnt = 0;
        while(idx < input.length() && checkSet.add(input.charAt(idx))) {
            cnt++;
            idx++;
        }
        return cnt != input.length();
    }

    private boolean checkOnlyNumber(String input) {
        if(input.length() != maxNumberSize) {
            return false;
        }
        char[] charArr = input.toCharArray();
        int idx = 0;
        int cnt = 0;
        while(idx < input.length() && Character.isDigit(charArr[idx])) {
            cnt++;
            idx++;
        }
        return cnt == input.length();
    }

    private boolean checkNumberLength(String input) {
        if(input.length() != maxNumberSize) {
            return false;
        }
        return true;
    }
}
