package kr.insup.domain;

import java.util.Random;

public class NumberGenerator {

    private static Random random = new Random();

    /**
     * 1~9의 서로 다른 숫자로 이루어진 임의의 n자리 숫자를 만들어준다.
     * @return n자리 숫자
     */
    public static String generateNumber() {
        String number = "";

        while (number.length() < GameOptions.HOW_MANY_DIGIT) {
            String singleDigit = generateDigit();
            number = concatDigit(number, singleDigit);
        }

        return number;
    }

    private static String concatDigit(String number, String singleDigit) {
        if (!number.contains(singleDigit)) {
            number = number.concat(singleDigit);
        }

        return number;
    }

    /**
     * 1~9 사이의 한자리 숫자를 만들어줌
     * @return String 타입의 한자리 숫자
     */
    public static String generateDigit() {
        int i = random.nextInt(9) + 1;

        return String.valueOf(i);
    }
}
