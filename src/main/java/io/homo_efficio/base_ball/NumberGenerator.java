package io.homo_efficio.base_ball;

import java.util.Random;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-13
 */
public class NumberGenerator {

    public static String generate(int len) {
        int[] numPool = getRandomNumPool();
        return getUniqueNumbersWithLength(len, numPool);
    }

    private static String getUniqueNumbersWithLength(int len, int[] numPool) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(numPool[i]);
        }
        return sb.toString();
    }

    private static int[] getRandomNumPool() {
        int[] numPool = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < numPool.length; i++) {
            int randomIndex = random.nextInt(9);
            swap(numPool, i, randomIndex);
        }
        return numPool;
    }

    private static void swap(int[] numPool, int i, int randomIndex) {
        int tmp;
        tmp = numPool[randomIndex];
        numPool[randomIndex] = numPool[i];
        numPool[i] = tmp;
    }
}
