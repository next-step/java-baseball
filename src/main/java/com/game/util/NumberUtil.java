package com.game.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class NumberUtil {

    private static final Random random = new Random();

    public static int randomNumber(int min, int max) {
        return random.nextInt(max) + min;
    }
}
