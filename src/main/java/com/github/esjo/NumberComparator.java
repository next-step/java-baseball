package com.github.esjo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.github.esjo.domain.Status;

import static com.github.esjo.domain.Message.*;
import static com.github.esjo.domain.Status.*;

public class NumberComparator {

    private Set<Integer> computerNumberSet;
    private Set<Integer> playerNumberSet;
    private Iterator<Integer> computerIterator;
    private Iterator<Integer> playerIterator;
    private HashMap<String, Integer> resultMap;
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    public NumberComparator() {
    }

    /**야구게임을 위한 numberSet을 비교
     * @param computerNumberSet 컴퓨터(상대방)의 야구게임 numberSet - 기준값
     * @param playerNumberSet 플레이어의 야구게임 numberSet
     * @return Status 플레이어의 상태
     * */
    public Status compareAwithB(Set<Integer> computerNumberSet, Set<Integer> playerNumberSet) {
        preCompare(computerNumberSet, playerNumberSet); // 변수초기화
        resultMap = compareElement(); // 각 자리수 비교
        if (resultMap.get(STRIKE) == 3) { // 3스트라이크 = 숫자를 모두 맞힘
            System.out.println(THREE_STRIKE_MSG.getValue());
            return PASS;
        }
        return postCompare(resultMap.get(STRIKE), resultMap.get(BALL));
    }

    /**
     * 변수 초기화
     * */
    private void preCompare(Set<Integer> computerNumberSet, Set<Integer> playerNumberSet) {
        this.computerNumberSet = computerNumberSet;
        this.playerNumberSet = playerNumberSet;
        this.computerIterator = computerNumberSet.iterator();
        this.playerIterator = playerNumberSet.iterator();
        this.resultMap = new HashMap<>();
        this.resultMap.put(STRIKE, 0);
        this.resultMap.put(BALL, 0);
    }

    /**
     * numberSet의 각 자리수 비교
     * @return HashMap<String, Integer> key(STRIKE, BALL)에 해당하는 개수를 value로 가지는 맵
     * */
    private HashMap<String, Integer> compareElement() {
        int computerIndex = 0;
        while (computerIterator.hasNext()) { // 컴퓨터(상대방)의 값을 기준으로 비교
            int computerValue = computerIterator.next();
            if (countStrike(computerIndex++, computerValue) > 0) { // 스트라이크 - 위치+숫자 모두 같은 경우 확인
                resultMap.put(STRIKE, resultMap.get(STRIKE) + 1);
            } else if (countBall(computerValue) > 0) { // 볼 - 스트라이크 처리후, 숫자 포함여부만 확인
                resultMap.put(BALL, resultMap.get(BALL) + 1);
            }
        }
        return resultMap;
    }

    /**
     * 위치+숫자 모두 같을 경우 STRIKE
     * */
    private int countStrike(int index, int value) {
        int playerIndex = 0;
        while (playerIterator.hasNext()) {
            if (++playerIndex == index && playerIterator.next() == value) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 숫자만 같은 경우 BALL
     * */
    private int countBall(int value) {
        if (playerNumberSet.contains(value)) {
            return 1;
        }
        return 0;
    }

    /**
     * 각 경우에 맞는 메세지 출력
     * */
    private Status postCompare(int strike, int ball) {
        String message = "";
        if (strike > 0) {
            message += strike + " 스트라이크 ";
        }
        if (ball > 0) {
            message += ball + " 볼 ";
        }
        System.out.println(message == "" ? NOTHING_MSG.getValue() : message);
        return FAIL;
    }
}
