package me.mkhwang.baseball.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BaseballValid {

    private static final int BALL_LENGTH = 3;

    public static boolean isBaseballValidLength(String ballNumber) {
        return ballNumber.length() == BALL_LENGTH;
    }

    public static boolean isBaseballValidDuplicate(String ballNumber) {
        char[] ballNumberArr = ballNumber.toCharArray();
        Map<Character, Integer> ballCountDuplicateMap = new HashMap<>();
        for (char ballCountChar : ballNumberArr) {
            ballCountDuplicateMap.put(ballCountChar, ballCountDuplicateMap.getOrDefault(ballCountChar,0)+1);
        }
        return ballCountDuplicateMap.size() == BALL_LENGTH;
    }
}
