package io.homo_efficio.base_ball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-13
 */
public class NumberGenerator {

    public static String generate() {
        String numbers = "111";
        Random random = new Random();
        while (!allUnique(numbers)) {
            int first = random.nextInt(8) + 1;
            int second = random.nextInt(8) + 1;
            int third = random.nextInt(8) + 1;

            numbers = String.valueOf(first) + second + third;
        }
        return numbers;
    }

    private static boolean allUnique(String nums) {
        check3Digits(nums);

        Set<String> numbers = new HashSet<>(3);
        String[] split = nums.split("");
        for (String num : split) {
            numbers.add(num);
        }
        return numbers.size() == 3;
    }

    private static void check3Digits(String nums) {
        if (nums == null || nums.length() != 3) {
            throw new IllegalArgumentException("숫자는 세 자리여야 합니다.");
        }
    }
}
