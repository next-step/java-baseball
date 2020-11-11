package com.netxstep.baseball;

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
}
