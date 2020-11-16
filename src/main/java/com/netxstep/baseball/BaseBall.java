package com.netxstep.baseball;

import com.netxstep.baseball.exception.BusinessError;
import com.netxstep.baseball.exception.BusinessException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BaseBall {

    private Map<Integer, Integer> answerMap = new LinkedHashMap<>();

    public Map<Integer, Integer> getAnswer() {
        return this.answerMap;
    }

    public void generateAnswer() {
        Random random = new Random();

        while (answerMap.keySet().size() != 3) {
            int answer = random.nextInt(10);

            if (answerMap.get(answer) == null) {
                answerMap.put(answer, answerMap.keySet().size());
            }
        }
    }

    public void inputAnswer(Integer input) {
        if (String.valueOf(input).length() != 3) {
            throw new BusinessException(BusinessError.INVALID_VALUE_LENGTH);
        }

        Map<Integer, Integer> inputMap = new LinkedHashMap<>();

        for (int pos = 0; pos < 3; pos++) {
            inputMap.put((int) String.valueOf(input).charAt(pos), pos);
        }

        if (inputMap.keySet().size() != 3) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }
    }
}
