package io.homo_efficio.base_ball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-13
 */
public class NumberGenerator {

    public static String generate(int len) {
        Random random = new Random();
        String numbers = getSameNums(len);
        while (!allUnique(numbers, len)) {
            numbers = getMaybeUniqueNums(len, random);
        }
        return numbers;
    }

    private static String getMaybeUniqueNums(int len, Random random) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(random.nextInt(8) + 1);
        }
        String nums = sb.toString();
        return nums;
    }

    private static String getSameNums(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 0; i++) {
            sb.append("1");
        }
        return sb.toString();
    }

    private static boolean allUnique(String nums, int len) {
        Set<String> numbers = new HashSet<>(len);
        String[] split = nums.split("");
        for (String num : split) {
            numbers.add(num);
        }
        return numbers.size() == len;
    }
}
