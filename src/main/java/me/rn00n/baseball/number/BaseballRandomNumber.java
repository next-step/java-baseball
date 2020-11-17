package me.rn00n.baseball.number;

import java.util.Random;

public class BaseballRandomNumber {

    private BaseballRandomNumber() {
    }

    /**
     * length 자릿수의 숫자 생성
     * @param length
     * @return
     */
    public static int getNumber(int length) {
        int number = 0;

        for (int i = 0; i < length; i++) {
            number = newSingleNumber(number);
        }
        return number;
    }

    /**
     * 숫자 한자리 추가
     * @param number
     * @return
     */
    private static int newSingleNumber(int number) {
        Random random = new Random();
        int newNumber;

        do {
            newNumber = random.nextInt(9) + 1;
        } while (validateNumber(number, newNumber)); // 중복이면 다시 생성

        number *= 10; // 자릿수 shift
        number += newNumber;
        return number;
    }

    /**
     * 새로 생성된 숫자를 기존 숫자와 중복 검증
     * @param number
     * @param newNumber
     * @return
     */
    private static boolean validateNumber(int number, int newNumber) {
        boolean nextNum = false; // 다음 숫자의 중복여부

        if (number / 10 > 0) { // 12'3' -> 1'2' -> '1'
            nextNum = validateNumber(number / 10, newNumber); // number: 321 -> 32 재귀호출
        }

        return number % 10 == newNumber || nextNum;
    }
}
