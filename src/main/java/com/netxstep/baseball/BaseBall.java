package com.netxstep.baseball;

import com.netxstep.baseball.domain.Result;
import com.netxstep.baseball.exception.BusinessError;
import com.netxstep.baseball.exception.BusinessException;

import java.util.*;

public class BaseBall {

    private Map<Integer, Integer> answerMap = new LinkedHashMap<>();
    private List<Map<Integer, Integer>> inputList = new ArrayList<>();

    public Map<Integer, Integer> getAnswerMap() {
        return this.answerMap;
    }

    public String getAnswer() {
        StringBuilder sb = new StringBuilder();

        for (Integer value : this.answerMap.keySet()) {
            sb.append(value);
        }

        return sb.toString();
    }

    public List<Map<Integer, Integer>> getInputList() {
        return this.inputList;
    }

    private void reset() {
        this.answerMap = new LinkedHashMap<>();
        this.inputList = new ArrayList<>();
    }

    public void generateAnswer() {
        reset();

        Random random = new Random();

        while (answerMap.keySet().size() != 3) {
            int answer = random.nextInt(10);

            if (answerMap.get(answer) == null) {
                answerMap.put(answer, answerMap.keySet().size());
            }
        }
    }

    public void inputAnswer(String input) {
        if (input.length() != 3) {
            throw new BusinessException(BusinessError.INVALID_VALUE_LENGTH);
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }

        Map<Integer, Integer> inputMap = new LinkedHashMap<>();

        for (int pos = 0; pos < 3; pos++) {
            inputMap.put(input.charAt(pos) - '0', pos);
        }

        if (inputMap.keySet().size() != 3) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }

        inputList.add(inputMap);
    }

    public Result check() {
        if (inputList.size() == 0) {
            throw new BusinessException(BusinessError.INVALID_VALUE_LENGTH);
        }

        Result result = new Result();

        Map<Integer, Integer> inputMap = inputList.get(inputList.size() - 1);

        for (Integer inputValue : inputMap.keySet()) {

            Integer inputPosition = inputMap.get(inputValue);
            Integer answerPosition = this.answerMap.get(inputValue);

            if (answerPosition != null && answerPosition.equals(inputPosition)) {
                result.incrementStrike();
                continue;
            }

            if (answerPosition != null) {
                result.incrementBall();
            }
        }

        return result;
    }

    public String print(Result result) {

        StringBuilder sb = new StringBuilder();

        if (result.getStrike() == 3) {
            return sb.append(String.format("승리하였습니다. 시도횟수: %s", inputList.size())).toString();
        }

        if (result.getStrike() != 0) {
            sb.append(String.format("스트라이크: %s", result.getStrike()));
        }

        if (result.getBall() != 0) {
            if (sb.toString().length() > 0) {
                sb.append(", ");
            }

            sb.append(String.format("볼: %s", result.getBall()));
        }

        if (result.getStrike() == 0 && result.getBall() == 0) {
            sb.append("낫싱!");
        }

        return sb.toString();
    }
}