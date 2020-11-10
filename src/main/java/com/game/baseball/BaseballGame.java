package com.game.baseball;

import com.game.common.Game;
import com.game.util.NumberUtil;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballGame implements Game {

    public String generateNumber() {
        Set<Integer> integerSet = new LinkedHashSet<>();
        while (integerSet.size() < 3) {
            int number = NumberUtil.randomNumber(1, 9);
            integerSet.add(number);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : integerSet) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
