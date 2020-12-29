package com.kakao.baseball.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 야구 게임이 구현된 클래스입니다.
 * 숫자야구 게임으로서 사용자의 입력에 따른 검증, 체크, 결과등이 수행됩니다.
 */
public class BaseballGame {

    private int baseballNumber;
    private int strikeCount;
    private int ballCount;

    private final int BASEBALL_LENGTH = 3;

    public BaseballGame() {
        initBaseballNumber();
    }

    public void initBaseballNumber() {
        Random random = new Random();
        int pivot = (int) Math.pow(10, BASEBALL_LENGTH - 1);
        int randomNumber = 0;

        while (!validateInput(randomNumber)) {
            randomNumber = random.nextInt(pivot * 9) + pivot;
        }
        baseballNumber = randomNumber;
    }

    public boolean validateInput(int input) {
        Set<Character> numSet = new HashSet<>();
        String strInput = String.valueOf(input);
        if ((input <= Math.pow(10, BASEBALL_LENGTH - 1)) || (input >= Math.pow(10, BASEBALL_LENGTH))) {
            return false;
        }
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (numSet.contains(strInput.charAt(i)) || strInput.charAt(i) == '0') {
                return false;
            }
            numSet.add(strInput.charAt(i));
        }
        return true;
    }

    public void checkUserInput(int input) {
        String computerNumber = String.valueOf(baseballNumber);
        String userInputNumber = String.valueOf(input);

        strikeCount = 0;
        ballCount = 0;

        checkStrike(computerNumber, userInputNumber);
        checkBall(computerNumber, userInputNumber);
    }

    private void checkStrike(String computerNumber, String userInputNumber) {
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            increaseStrikeCountIfEqualNumber(computerNumber.charAt(i), userInputNumber.charAt(i));
        }
    }

    private void increaseStrikeCountIfEqualNumber(char computerNum, char userNum) {
        if (computerNum == userNum) {
            strikeCount++;
        }
    }

    private void checkBall(String computerNumber, String userInputNumber) {
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            for (int j = 0; j < BASEBALL_LENGTH; j++) {
                if (i == j) {
                    continue;
                }
                increaseBallCountIfEqualNumber(computerNumber.charAt(i), userInputNumber.charAt(j));
            }
        }
    }


    private void increaseBallCountIfEqualNumber(char computerNum, char userNum) {
        if (computerNum == userNum) {
            ballCount++;
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        if (strikeCount == BASEBALL_LENGTH) {
            result.append(BASEBALL_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return result.toString();
        }
        if (strikeCount == 0 && ballCount == 0) {
            result.append("낫싱");
            return result.toString();
        }
        return getCountString();
    }

    public String getCountString() {
        StringBuilder result = new StringBuilder();
        if (strikeCount > 0) {
            result.append(strikeCount + " 스트라이크 ");
        }
        if (ballCount > 0) {
            result.append(ballCount + " 볼 ");
        }
        return result.toString();
    }

    public boolean isWin() {
        return strikeCount == BASEBALL_LENGTH;
    }
}
