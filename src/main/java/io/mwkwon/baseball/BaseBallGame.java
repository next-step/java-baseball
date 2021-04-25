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

    /**
     * 사용자가 입력한 숫자와 컴퓨터가 가지고 있는 숫자를 비교하여 결과를 반환
     * @param computerNumbers: 컴퓨터가 생성한 1에서 9까지 임의의 수 3개로 이루어진 String
     * @param userNumbers: user가 입력한 1에서 9까지 임의의 수 3개로 이루어진 String
     * @return strikeCount, ballCount를 이용하여 생성한 GameResult Object
     */
    public GameResult executeGame(String computerNumbers, String userNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < MAX_VALUE_LENGTH; i++) {
            char userNumber = userNumbers.charAt(i);
            strikeCount += this.calcStrikeCount(userNumber, computerNumbers.charAt(i));
            ballCount += this.calcBallCount(userNumber, computerNumbers);
        }
        ballCount -= strikeCount;
        return new GameResult(strikeCount, ballCount);
    }

    /**
     * 사용자가 입력한 데이터에 대한 유효성 검사
     * @param inputString: 사용자 입력 String
     * @param regex: 유효성 체크를 위한 정규 표현식
     * @return: 사용 가능 입력 String인 경우 true, 아닌 경우 false
     */
    public boolean validInputString(String inputString, String regex) {
        if (inputString == null) {
            return false;
        }
        String targetString = this.removeDuplicateString(inputString);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetString);
        return matcher.matches();
    }

    /**
     * 게임 계속 진행여부 확인
     * @param continueFlag: 게임 계속 진행여부 확인 flag 값
     * @return continueFlag == "1" true, continueFlag  == "2" false
     */
    public boolean isContinueGame(String continueFlag) {
        int value = Integer.valueOf(continueFlag);
        if (!(value > 0) || !(value <= 2)) {
            throw new IllegalArgumentException("continueFlag 값은 1 또는 2만 허용합니다.");
        }
        return value == 1;
    }

    /**
     * 사용자가 입력한 데이터에 중복 문자 제거
     * @param inputString: 사용자 입력 String
     * @return 중복 제거가 완료된 String
     */
    private String removeDuplicateString(String inputString) {
        if (inputString.length() == 1) {
            return inputString;
        }
        if (inputString.substring(1).contains(inputString.substring(0, 1))) {
            return removeDuplicateString(inputString.substring(1));
        }
        return inputString.substring(0, 1) + removeDuplicateString(inputString.substring(1));
    }

    /**
     * 사용자 입력 값과 컴퓨터 값을 비교하여 strike 여부 계산
     * @param userNumber 사용자가 입력한 i번째 숫자 char
     * @param computerNumber 컴퓨터가 생성한 i번째 숫자 char
     * @return strike 이면 1, 아니면 0 반환
     */
    private int calcStrikeCount(char userNumber, char computerNumber) {
        int strikeCount = 0;
        if (userNumber == computerNumber) {
            return ++strikeCount;
        }
        return strikeCount;
    }

    /**
     * 사용자 입력 값과 컴퓨터 값을 비교하여 ball 여부 계산
     * @param userNumber 사용자가 입력한 i번째 숫자 char
     * @param computerNumbers 컴퓨터가 생성한 1에서 9까지 임의의 수 3개로 이루어진 String
     * @return ball 이면 1, 아니면 0 반환
     */
    private int calcBallCount(char userNumber, String computerNumbers) {
        int ballCount = 0;
        if (computerNumbers.indexOf(userNumber) > -1) {
            return ++ballCount;
        }
        return ballCount;
    }
}
