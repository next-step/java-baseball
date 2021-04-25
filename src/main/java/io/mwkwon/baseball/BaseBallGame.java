package io.mwkwon.baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * 숫자 야구 게임 구현 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class BaseBallGame {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int MAX_VALUE_LENGTH = 3;

    /***
     * 1에서 9까지 서로 다른 임의의 수를 set으로 생성하여 String으로 변환하여 반환
     * @return 1에서 9까지 서로 다른 임의의 수로 이루어진 길이 3의 String
     */
    public String createComputerNumbers() {
        Random random = new Random();
        Set<String> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() < MAX_VALUE_LENGTH) {
            int number = random.nextInt(MAX_VALUE) + MIN_VALUE;
            computerNumbers.add(String.valueOf(number));
        }
        return String.join("", computerNumbers);
    }
}
