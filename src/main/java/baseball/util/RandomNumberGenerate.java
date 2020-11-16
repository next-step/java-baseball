package baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerate {
    private static List<Integer> numbers;

    static {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    /**
     * 지정된 길이의 랜덤한 난수 생성
     * @param length 난수의 길이
     * @return random number
     */
    public static int generate(int length) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.shuffle(copyNumbers);

        int value = 0;
        for (int i = 0; i < length; i++) {
            value += (int) Math.pow(10, i) * copyNumbers.get(i);
        }
        return value;
    }
}
