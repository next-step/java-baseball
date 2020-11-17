package com.github.esjo;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator {

    private static int min; // 생성되는 숫자의 최소값
    private static int max; // 생성되는 숫자의 최대값
    private static int numberOfDigit; // 사용자 입력 유효 자리수
    private static NumberGenerator numberGenerator; // 객체
    private static String input; // 사용자 입력값

    /** default Constructor */
    private NumberGenerator() {
    }

    private NumberGenerator(int min, int max, int numberOfDigit) {
        this.min = min;
        this.max = max;
        this.numberOfDigit = numberOfDigit;
        this.input = null;
    }

    /** NumberGenerator객체 초기화 메서드
     * @param min 생성되는 숫자의 최소값
     * @param max 생성되는 숫자의 최대값
     * @param numberOfDigit 사용자 입력 유효 자리수
     * @return NumberGenerator 야구게임을 위한 numberSet생성 객체
     * */
    public static NumberGenerator createNumberGenerator(int min, int max, int numberOfDigit) {
        numberGenerator = new NumberGenerator(min, max, numberOfDigit);
        return numberGenerator;
    }

    /**
     * 범위내의 랜덤 정수를 생성
     * @return min이상 max이하의 랜덤 정수
     * */
    public int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
