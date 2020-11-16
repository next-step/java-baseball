package app;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static Set<Integer> numbers;
    private static StringBuilder sb;

    /**
     * 임의의 중북되지 않는 3자리 숫자 생성
     */
    public static String generate() {
        sb = new StringBuilder();
        numbers = new HashSet<>();
        while (numbers.size() < InputValidator.MAX_LENGTH) {
            int random = (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
            checkDuplicateNumber(random);
            numbers.add(random);
        }

        return sb.toString();
    }

    /**
     * 중복된 값이 아닐 경우 StringBuffer 에 append
     *
     * @param randomNumber 입의로 생성된 랜덤값
     */
    private static void checkDuplicateNumber(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            sb.append(randomNumber);
        }
    }
}
