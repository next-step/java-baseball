package app;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    /**
     * 임의의 중북되지 않는 3자리 숫자 생성
     */
    public static String generate() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < InputValidator.MAX_LENGTH) {
            int random = (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
            if (!numbers.contains(random)) {
                sb.append(random);
            }
            numbers.add(random);
        }

        return sb.toString();
    }
}
