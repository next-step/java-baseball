package me.lozm.baseball.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static me.lozm.baseball.common.CommonUtils.*;

public class BaseballNumber {

    private Map<Integer, Boolean> candidateMap = new HashMap<>(); // 정답 후보


    public String getRandomNumberToString() {
        initializeCandidateMap();

        StringBuffer randomNumber = new StringBuffer();
        while (randomNumber.length() < ANSWER_SIZE) {
            randomNumber.append(getRandomNumber());
        }

        return randomNumber.toString();
    }


    private void initializeCandidateMap() {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            candidateMap.put(i, CANDIDATE_IS_NOT_USED);
        }
    }

    private String getRandomNumber() {
        Integer randomKey = getRandomKey();

        if (candidateMap.get(randomKey).equals(CANDIDATE_IS_USED)) {
            return "";
        }

        candidateMap.put(randomKey, CANDIDATE_IS_USED);
        return String.valueOf(randomKey);
    }

    private Integer getRandomKey() {
        Integer[] keys = candidateMap.keySet()
                .toArray(new Integer[candidateMap.size()]);
        return keys[new Random().nextInt(keys.length)];

    }

}