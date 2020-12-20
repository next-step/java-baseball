package com.kakao.baseball.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

    private int baseballNumber;
    private int strikeCount;
    private int ballCount;

    private final int BASEBALL_LENGTH = 3;

    public BaseballGame() {
        this.baseballNumber = initBaseballNumber();
    }

    public int initBaseballNumber() {
        Random random = new Random();
        int randomNumber = 0;

        while (!this.validateInput(randomNumber)) {
            randomNumber = random.nextInt(900)+100;
        }

        return randomNumber;
    }

    public boolean validateInput(int input) {
        Set<Character> numSet = new HashSet<>();
        String strInput = String.valueOf(input);

        if ((input <= 100) || (input >= 1000)) {
            return false;
        }
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (strInput.charAt(i) == '0') {
                return false;
            }
            if (numSet.contains(strInput.charAt(i))) {
                return false;
            }
            numSet.add(strInput.charAt(i));
        }

        return true;
    }

    public void checkUserInput(int input) {
        String computerNumber = String.valueOf(this.baseballNumber);
        String userInputNumber = String.valueOf(input);

        this.strikeCount = 0;
        this.ballCount = 0;

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
            this.strikeCount++;
        }
    }

    private void checkBall(String computerNumber, String userInputNumber) {
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            for (int j = 0; j < BASEBALL_LENGTH; j++) {
                if(i==j){
                    continue;
                }
                increaseBallCountIfEqualNumber(computerNumber.charAt(i), userInputNumber.charAt(j));
            }
        }
    }

    private void increaseBallCountIfEqualNumber(char computerNum, char userNum) {
        if (computerNum == userNum) {
            this.ballCount++;
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        if (this.strikeCount == 3) {
            result.append(BASEBALL_LENGTH);
            result.append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return result.toString();
        }
        if (this.strikeCount > 0) {
            result.append(this.strikeCount);
            result.append(" 스트라이크 ");
        }
        if (this.ballCount > 0) {
            result.append(this.ballCount);
            result.append(" 볼 ");
        }
        if (result.length() == 0) {
            result.append("숫자를 하나도 맞히지 못했습니다.");
        }
        return result.toString();
    }

    public boolean isWin() {
        return this.strikeCount == 3;
    }
}
