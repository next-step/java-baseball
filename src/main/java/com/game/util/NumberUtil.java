package com.game.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class NumberUtil {

    private static final Random random = new Random();

    /**
     * 랜덤 숫자 생성
     * @param min 최소 숫자
     * @param max 최대 숫자
     * @return 랜덤 숫자
     */
    public static int randomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
