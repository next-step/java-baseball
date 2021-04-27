package io.mwkwon.baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static final int BALL_COUNT = 3;

    /***
     * 1에서 9까지 서로 다른 임의의 수를 set으로 생성하여 String으로 변환하여 반환
     * @return 1에서 9까지 서로 다른 임의의 수로 이루어진 길이 3의 String
     */
    public String createComputerNumbers() {
        Random random = new Random();
        Set<String> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() < BALL_COUNT) {
            int number = random.nextInt(MAX_VALUE) + MIN_VALUE;
            computerNumbers.add(String.valueOf(number));
        }
        return String.join("", computerNumbers);
    }

    /**
     * 사용자가 입력한 숫자와 컴퓨터가 가지고 있는 숫자를 비교하여 결과를 반환
     * @param gameControlVO : 게임 정보 관리를 위한 vo 객체
     * @param userNumbers : user가 입력한 1에서 9까지 임의의 수 3개로 이루어진 String
     * @return strikeCount, ballCount를 이용하여 생성한 GameResult Object
     */
    public void executeGame(GameControlVO gameControlVO, String userNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        String computerNumbers = gameControlVO.getComputerNumbers();
        for (int i = 0; i < BALL_COUNT; i++) {
            char userNumber = userNumbers.charAt(i);
            strikeCount += this.calcStrikeCount(userNumber, computerNumbers.charAt(i));
            ballCount += this.calcBallCount(userNumber, computerNumbers, i);
        }
        gameControlVO.setStrikeCount(strikeCount);
        gameControlVO.setBallCount(ballCount);
    }

    /**
     * 사용자 입력 값과 컴퓨터 값을 비교하여 strike 여부 계산
     * @param userNumber 사용자가 입력한 i번째 숫자 char
     * @param computerNumber 컴퓨터가 생성한 i번째 숫자 char
     * @return strike 이면 true, 아니면 false 반환
     */
    private int calcStrikeCount(char userNumber, char computerNumber) {
        if (userNumber == computerNumber) {
            return 1;
        }
        return 0;
    }

    /**
     * 사용자 입력 값과 컴퓨터 값을 비교하여 ball 여부 계산
     * @param userNumber 사용자가 입력한 i번째 숫자 char
     * @param computerNumbers 컴퓨터가 생성한 1에서 9까지 임의의 수 3개로 이루어진 String
     * @param index 스크라이크 여부 확인을 위한 index 값
     * @return ball 이면 true, 아니면 false 반환
     */
    private int calcBallCount(char userNumber, String computerNumbers, int index) {
        if (userNumber == computerNumbers.charAt(index)) {
            return 0;
        }
        if (computerNumbers.indexOf(userNumber) > -1) {
            return 1;
        }
        return 0;
    }
}
